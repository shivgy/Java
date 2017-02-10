package readtextfile;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class ReadTxt {
	String longitude;
	String latitude;
	String speed;
	String angle;
	String altitude;
	String noOfSatellite;
	
	String ignition;
	String doorStatus;
	String alertvalue;
	String movement;
	String vehicleBatteryVoltage;
	String iButton;
	String gpsOdo;
	
	
	
	final static String FILE_NAME = "C:\\...\\abcd.txt";
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] args) throws IOException {
		ReadTxt text = new ReadTxt();
		text.readFile(FILE_NAME);
	}

	public void readFile(String aFileName)throws IOException{
		Set<Integer> totalKeys = new TreeSet();
		ArrayList list = new ArrayList();
		Set<String> mySet = new HashSet<>();
		
		//totalKeys = null;
		Path path = Paths.get(aFileName);
		try(Scanner sc = new Scanner(path,ENCODING.name())){
			while(sc.hasNextLine()){
				String str = null;
				str = sc.nextLine();
				try {
					if(str.contains("Inserting Polling Packet >>>")){
						
						str = str.substring(str.indexOf('>')+3, str.length());
						mySet.add(str);
						list = processPacket("X"+str);
						 //set.addAll(Arrays.asList(array));
						try {
							totalKeys.addAll(list);
						} catch (Exception e) {
							e.printStackTrace();
						} 
					}
				} catch (Exception e) {
					str = str.substring(str.indexOf('$'),str.length());
					System.out.println("Gopal Errror>>> "+str + e.getMessage());
				}
			}
			System.out.println(totalKeys);
			/*Iterator<String> it = mySet.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}*/
		}
		catch(Exception e){
			Iterator<String> it = mySet.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			System.out.println("Gopi Error >>> "  +e.toString());

		}
	}
	
	
	private ArrayList<Integer> processPacket(String rxstring) {
		ArrayList<Integer> lst = new ArrayList<>();
		Set<Integer> keys = new HashSet<Integer>();
		
		try {
			String[] datas = rxstring.split(":");
			keys = getiostream(datas[1]);
			lst.addAll(keys);
			/*for (String data : datas) { 
				getGPSelement(datas[0]);
				keys = getiostream(datas[1]);
			}*/	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lst;
	}
	
	
	
	
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
		}
	}
	
	
	private Set<Integer> getiostream(String data){ 
		TreeMap<Integer, String> hm = new TreeMap<Integer, String>();
		Set<Integer> keys = hm.keySet();
		try{
			
			String[] st = data.split("\\$");
			for(int i = 0; i < st.length; i++){
				String[] temp = st[i].split("\\=");
				hm.put(Integer.valueOf(temp[0]), temp[1]);
			}
			
	        /*for(int key: keys){
	        	
	            System.out.println(key);
	        }*/
			//System.out.println(hm);
			/*ignition = hm.containsKey(1)?hm.get(1):"0";
			doorStatus = hm.containsKey(2)?hm.get(2):"0";
			alertvalue = hm.containsKey(4)?hm.get(4):"0";
			movement = hm.containsKey(240)?hm.get(240):"0";
			vehicleBatteryVoltage = hm.containsKey(66)?String.valueOf(Float.parseFloat(hm.get(66))/1000):"0";//divide by 1000 to get value in milli volts
			//vehicleBatteryVoltage = hm.containsKey(66)?hm.get(66):"0";
			iButton = hm.containsKey(67)?hm.get(67):"0"; 
			gpsOdo = hm.containsKey(199)?hm.get(199):"0";*/
		}catch(Exception e){
			ignition = "";
			doorStatus = "";
			alertvalue = "";
			movement = "";
			vehicleBatteryVoltage = "";
			iButton = "";
			gpsOdo = "";
		}
		return keys;
	}
