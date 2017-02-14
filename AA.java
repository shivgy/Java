/**
 * Input: aaaabbbffcaa
 * Output: 4a3b2fc2a
 */

import java.util.Scanner;

public class AA{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int count =1;
		char c = input.charAt(0);
		String temp = null;
		String finalString = "";
		
		for(int i = 1; i < input.length(); i++){
			
			if(c == input.charAt(i)){
				count++;
				
			}else{
				if(count > 1){
					temp = String.valueOf(count)+String.valueOf(c);
				}else{
					temp = String.valueOf(c);
				}
				count = 1;
				c = input.charAt(i);
				finalString = finalString+temp;
			}
			
		}
		if(count > 1){
			temp = String.valueOf(count)+String.valueOf(c);
		}else{
			temp = String.valueOf(c);
		}
		finalString += temp;
		System.out.println(finalString);
		
	}
}
