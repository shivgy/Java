import java.util.Scanner;

public class Comparison {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int c = 0;
		int k = 0;
		
		for(int i = 0; i < n; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			c = a - b;
			
			 /* if the difference c is positive, MSB = 0 and k = 0 (integer)
			 * if the difference c is negative, MSB = 1 and k = -1 (integer)
			 */
			k = c>>31; // shift the difference by 31 bit to get the MSB of c
		
			/* k = 0 for c > 0
			 * k = -1 for c < 0 => k*c will be positive
			 */
			System.out.print("Maximum number is: ");
			System.out.print(a + (k*c));
		}
		sc.close();
		
	}
}
