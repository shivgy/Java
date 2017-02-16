import java.util.ArrayList;

/**
 * Input: 4a3b2fc2a
 * Output: aaaabbbffcaa
 */

import java.util.Scanner;

public class RepeatedChar{
	
	public static void main(String[] args){ 
		Scanner sc = new Scanner(System.in);
		String _input_str = sc.next();
		
		ArrayList<String> _input_arr = new ArrayList<>();
		String temp;
		String final_string = "";
		int _count = -1;
		int _len = 0;
		String _str;
		
		for(int i = 0; i < _input_str.length(); i++){
			if(Character.isLetter(_input_str.charAt(i))){
				_count++;
				_input_arr.add(_input_str.substring(0,i+1));
				_input_str = _input_str.substring(i+1, _input_str.length());
				i = -1;
			}
		}
		
			for(int i = 0; i < _input_arr.size(); i++){
				_len = _input_arr.get(i).length()-1;
				if(_len != 0){
					int _times = Integer.valueOf(_input_arr.get(i).substring(0, _len));
					for(int j = 0; j < _times; j++){
						final_string = final_string + _input_arr.get(i).substring(_len);
					}
				}else{
					final_string = final_string + _input_arr.get(i);
				}
				
			}
		
		System.out.println(final_string);
	}
}
