
import java.util.Scanner;

public class Addition_without_operator_iter  {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		while(b != 0){
			int sum = a^b;
			int carry = (a&b)<<1;
			a = sum;
			b = carry;
		}
		System.out.println("Sum of given two number is : " + a);
	}
}
