package readtextfile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SuccessOTA {
	 final static Charset ENCODING = StandardCharsets.UTF_8;
	int[] SuccessIMEI = new int[500];
	public static void main(String[] args) throws IOException {
		SuccessOTA text = new SuccessOTA();
		
		File file = new File("C:/../Logdata/");
        File[] files = file.listFiles();
        
        for(File f: files){
        	//System.out.println(f.getName()+" >>> " + f.length());
        	text.readFile(f.getPath().toString());

        }
        /*Print the count*/ 
        System.out.println("Total Number of Files: " + files.length);
	}
	
	public void readFile(String aFileName)throws IOException{
		
		Path path = Paths.get(aFileName);
		try(Scanner sc = new Scanner(path,ENCODING.name())){
			
			while(sc.hasNextLine()){
				String str = sc.nextLine();
				
				if(str.contains("Successful")){
					System.out.println(aFileName.substring(aFileName.indexOf("txt")+3, aFileName.length()-4));
					/*str.substring(str.startsWith("txt"), str.length())*/
					//System.out.println("Success" + aFileName.toString());
					break;
				}
			}
		}
	}

}
