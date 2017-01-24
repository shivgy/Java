package readtextfile;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadTxt {
	final static String FILE_NAME = "C:\\Users\\Gopal\\Desktop\\infosys.txt";
	 final static Charset ENCODING = StandardCharsets.UTF_8;
	//static Path path = Paths.get(FILE_NAME);
	
	public static void main(String[] args) throws IOException {
		 ReadTxt text = new ReadTxt();
		 text.readFile(FILE_NAME);
	}
	
	public void readFile(String aFileName)throws IOException{
		Path path = Paths.get(aFileName);
		try(Scanner sc = new Scanner(path,ENCODING.name())){
			while(sc.hasNextLine()){
				String str = sc.nextLine();
				
				/*ERM Device*/
				if(str.contains("$SLU")){
					str = str.substring(str.indexOf("$SLU"), str.indexOf("#"));
					System.out.println(str.substring(4,19));
					//System.out.println(str);
				}
				//SUN100 Device
				if(str.contains("Recieved packet:")){
					str = str.substring(str.indexOf("$SUN"), str.indexOf("|#"));
					System.out.println(str.substring(str.length()-15, str.length()));
				}
			}
		}
	}
}
