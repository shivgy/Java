/*
*This Program will return sum of two integer without using + operator
*Recursive Method
*/

import java.util.Scanner;

public class Addition_without_operator {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		System.out.println("Sum of given two number is : " + add_num(a,b));
	}
	
	public static int add_num(int a, int b){
		if(b == 0)
			return a;
		int sum = a^b;
		int carry = (a&b)<<1;
		return add_num(sum,carry);
	}
	
}
