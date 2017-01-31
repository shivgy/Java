import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TreeMap;
import org.apache.log4j.Logger;


/**
 * @author Mr.Shiv Gopal Yadav
 */
public class ClientHandler extends Thread { 

	private String latitude = "0",longitude = "0",speed = "0", angle = "0", altitude = "0", noOfSatellite = "0", ignition = "0", alertvalue = "", temperature = "0", gpsOdo = "0";
	private static String vehicleBatteryVoltage = "0", movement = "0", iButton = "0",doorStatus = "0",alertType = "";
	private static long gpsDateTime;

	static {
		InitializeLogger.intializeLogger(LOG4J_PROPERTIES);
	}

	private static final Logger logger = Logger.getLogger(ClientHandler.class); 

	private static void goSleep(final long milliSec) {
		try {
			Thread.sleep(milliSec);
		} catch (final InterruptedException e) {
			logger.warn("Sleeping client interrupted", e);
		}
	} 

	private static void writeResponse(final OutputStream out, final String response) throws IOException {
		logger.info("Sending response to client: " + response);
		out.write(response.getBytes());
		out.write(0x10);
		out.write(0x03);
		out.flush();
	}

	private boolean flag,modelflag=true;

	private final ClientModel clientModel;
	private final DbModel statusModel;
	private final SimpleDateFormat dateFormat;

	private final Socket clientSocket;
	private String imei;
	private String gpsdate = "";

	public ClientHandler(final ClientModel clientModel, final DbModel statusModel, final Socket clientSocket) {
		this.flag = true;
		this.clientModel = clientModel;
		this.statusModel = statusModel;
		this.clientSocket = clientSocket;
		this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public boolean isClosed() {
		return clientSocket.isClosed();
	}

	@Override
	public void run() {
		try {
			final InputStream in = clientSocket.getInputStream(); 
			while (flag) {
				if (!(in.available() > 0)) {
					goSleep(3000);
					continue;
				}
				processClients(in); 
			}
		} catch (final IOException e) {
			
			logger.error("Error while processing client socket.", e);
		} finally {
			try {
				setStopFlag();
				if (!clientSocket.isClosed())
					clientSocket.close();
			} catch (final IOException e) {
				logger.warn("Error while closing client connection.", e);
			}
		}
	}

	private void processClients(InputStream in) {
		try{

			DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
			imei = dis.readUTF(); 
			dos.writeBoolean(true);
			if(modelflag) {
				clientModel.addClient(imei, this);
				modelflag = false;
			}
			while (true) {
				byte[] packet = ByteWrapper.unwrapFromStream(dis);
				if (packet == null) { 
					break;
				}
				// register supported codecs
				CodecStore.getInstance().register(AvlData.getCodec());
				CodecStore.getInstance().register(AvlDataFM4.getCodec());
				CodecStore.getInstance().register(AvlDataGH.getCodec());
				System.out.println("Recived Packet is >>> " + packet);
				AvlData decoder = CodecStore.getInstance().getSuitableCodec(packet);
				if (decoder == null) {
					System.out.println("Unknown packet format: "+ Tools.bufferToHex(packet));
					dos.writeInt(0);
				} else { 
					AvlData[] decoded = decoder.decode(packet);  
					dos.writeInt(decoded.length);
					CallTeltonicaSp(decoded,imei,clientSocket); 
				}
			}
		}catch(Exception e){
			logger.error("Error in processClient Method >>>"+e);
		}
	}

	private void CallTeltonicaSp(AvlData[] decoded, String imei, Socket clientSocket2) {
		try {
			String rxstring = ""; 
			for (AvlData avlData : decoded) {
				System.out.println("AVLDATA is : " + avlData); 
				rxstring += avlData; 
			} 
			logger.info("Received Data >>> "+ rxstring);
			processPacket(rxstring, imei);
		} catch (Exception e) {
			logger.error("Error in CallTeltonicaSp Method >>>"+e);
		} 
	}
	/**
	 * Method to separate GPS element(Longitude, Latitude, Speed, Angle, Altitude, No of satellites) from AVL data
	 * @param string
	 */
	private void getGPSelement(String string) {
		try{
			String[] tempArray = string.split("\\$");
			longitude = String.valueOf(Float.parseFloat(tempArray[0].replace("X=", ""))/10000000);
			latitude = String.valueOf(Float.parseFloat(tempArray[1].replace("Y=", ""))/10000000);
			speed = tempArray[2].replace("Speed=", "");
			angle = tempArray[3].replace("Angle=", "");
			altitude = tempArray[4].replace("Altitude=", "");
			noOfSatellite = tempArray[5].replace("Satellites=", "");
		}catch(Exception e){
			longitude = "";
			latitude = "";
			speed = "";
			angle = "";
			altitude = "";
			noOfSatellite = "";
			logger.error("Error in GPS Element data processing"+string);
		}
	}
	
	/**
	 *Method to separate GPS element(Longitude, Latitude, Speed, Angle, Altitude, No of satellites) from AVL data 
	 * @param data
	 * Sample Packet: 1=1$2=0$240=1$9=18$66=14146$24=55$199=15$72=0$78=0
	 */
		private void getiostream(String data){ 
			try{
				TreeMap<Integer, String> hm = new TreeMap<Integer, String>();
				String[] st = data.split("\\$");
				for(int i = 0; i < st.length; i++){
					String[] temp = st[i].split("\\=");
					hm.put(Integer.valueOf(temp[0]), temp[1]);
				}
				ignition = hm.containsKey(1)?hm.get(1):"0";
				doorStatus = hm.containsKey(2)?hm.get(2):"0";
				alertvalue = hm.containsKey(4)?hm.get(4):"0";
				movement = hm.containsKey(240)?hm.get(240):"0";
				vehicleBatteryVoltage = hm.containsKey(66)?String.valueOf(Float.parseFloat(hm.get(66))/1000):"0";//divide by 1000 to get value in milli volts
				//vehicleBatteryVoltage = hm.containsKey(66)?hm.get(66):"0";
				iButton = hm.containsKey(67)?hm.get(67):"0"; 
				gpsOdo = hm.containsKey(199)?hm.get(199):"0";
			}catch(Exception e){
				ignition = "";
				doorStatus = "";
				alertvalue = "";
				movement = "";
				vehicleBatteryVoltage = "";
				iButton = "";
				gpsOdo = "";
				logger.error("Error in Input Output data processing"+data);
			}
		}
		
		/**
		 * Method to get GPS Date Time
		 * @param DateTime
		 */
		private void getTimeStamp(String DateTime) {
			try{
				Long DateTimes = Long.valueOf(DateTime);
				gpsdate = dateFormat.format(new Date(DateTimes));
			}catch(Exception e){
				gpsdate = "";
				logger.error("Error in Date Time data processing >>> "+ DateTime);
			}
		}
		
	//#X=798532160$Y=68979480$Speed=0$Angle=175$Altitude=3$Satellites=9
	//$1=1$2=0$4=0$240=1$67=10403$66=19490$24=0$199=0$^$:1470045663764:0
	private void processPacket(String rxstring, String iMEI) {
		try {
			String[] dataArrays = null;
			try{
			rxstring =  rxstring.replace("]", "").replace("[", "").replace("^","");
			}catch(Exception e){
				logger.error("Error in replace Shiv processPacket Method >>>"+e+rxstring);
			}
			try{
			dataArrays = rxstring.split("X");
			}catch(Exception e){
				logger.error("Error Ramesh processPacket Method >>>"+e+rxstring);
			}
			for (String data : dataArrays) {
				if(data.length() > 5){
					String[] datas = rxstring.split(":");
					getGPSelement(datas[1]);
					getiostream(datas[2]);
					getTimeStamp(datas[3]);
					if(alertvalue.equals("1")){
						alertType = "1"; 
						statusModel.InsertAlertData(alertType,longitude,latitude,speed,angle,altitude,noOfSatellite,ignition,doorStatus,alertvalue,vehicleBatteryVoltage,
								temperature,gpsOdo,gpsdate,data,iMEI,String.valueOf(getId()));

						logger.info("Inserting Alert Packet >>> "+ data);
					}
					else{
						statusModel.InsertData(longitude,latitude,speed,angle,altitude,noOfSatellite,ignition,doorStatus,alertvalue,vehicleBatteryVoltage,
								temperature,gpsOdo,gpsdate,data,iMEI,String.valueOf(getId()));

						logger.info("Inserting Polling Packet >>> "+ data);
					}
				}
			}	
			} catch (Exception e) { 
			logger.error("Error in out try processPacket Method >>>"+e+rxstring);
		} 
	}

	public void setStopFlag() {
		flag = false;
		clientModel.removeClient(imei);
	}

	public void writeResponse(final String response) throws IOException {
		writeResponse(clientSocket.getOutputStream(), response);
	}
}
