package blr;

import java.util.Arrays;
import java.util.Scanner;

public class Repetition 
{
	//1. Find the Average of number in a running stream.
	//Default Constructor
	Repetition()
	{
		
	}
	
	//1. Consider input String in Sorted order.
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArr = new String[str.length()];
		
		for(int i = 0; i < strArr.length; i++)
		{
			strArr[i] = str.substring(i, i+1);
		}
		System.out.println(Arrays.toString(strArr));
		
		String temp;
		for(int i = 0; i < strArr.length; i++)
		{
			int charCount = 0;
			temp = strArr[i];
			while((i+charCount)<strArr.length &&strArr[i+charCount].equals(temp))
			{
				charCount++;
			}
			System.out.print(temp+""+charCount);
			i+=charCount-1;
		}
	}
}