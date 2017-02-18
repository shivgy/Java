import java.util.Scanner;

/**
 * @Author: Shiv Gopal Yadav
 * Date: 18-02-2017
 */


public class LeftRotation{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int _element = sc.nextInt();
		int _shift = sc.nextInt();
		
		int temp;//temporary variable to store first element of the array
		
		int[] _arr = new int[_element];
		
		//Inserting elements into array
		for(int i = 0; i < _element; i++){
			_arr[i] = sc.nextInt();
		}
		sc.close();
		
		for(int shift = 0; shift < _shift; shift++){
			temp = _arr[0];
			for(int i = 0; i < _element-1; i++){
				_arr[i] = _arr[i+1]; 
			}
			_arr[_element-1] = temp;
		}
		
		for(int i = 0; i < _element; i++){
			System.out.print(_arr[i]+" ");
		}
	}
}
 
