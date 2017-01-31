package readtextfile;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadTxt {
	final static String FILE_NAME = "C:\\Users\\...\\infosys.txt";
	 final static Charset ENCODING = StandardCharsets.UTF_8;
	//static Path path = Paths.get(FILE_NAME);
	
	public static void main(String[] args) throws IOException {
		 ReadTxt text = new ReadTxt();
		 text.readFile(FILE_NAME);
	}
	
	public void readFile(String aFileName)throws IOException{
		Set mySet = new HashSet<>();
		
		Path path = Paths.get(aFileName);
		try(Scanner sc = new Scanner(path,ENCODING.name())){
			while(sc.hasNextLine()){
				String str = sc.nextLine();
				
				/*ABC Device*/
				if(str.contains("$ABC")){
					str = str.substring(str.indexOf("$XYZ"), str.indexOf("|#"));
					str = str.substring(str.length()-15, str.length());
					mySet.add(str);
				}
				//XYZ Device
				if(str.contains("Recieved packet:")){
					str = str.substring(str.indexOf("$XYZ"), str.indexOf("|#"));
					System.out.println(str.substring(str.length()-15, str.length()));
				}
			}
			System.out.println(mySet);
		}
		catch(Exception e){
			System.out.println(e.toString());
			System.out.println(mySet);
		}
	}
}
