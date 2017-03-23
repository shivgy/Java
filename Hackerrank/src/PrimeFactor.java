package shiv;

import java.util.Scanner;

public class PrimeFactor {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int a0 = 0; a0 < t; a0++){
			int maxPrime = 1;
			long n = in.nextLong();
			
			/*Number of 2s that divide n*/
			while(n%2 == 0){
				n /= 2;
				maxPrime = 2;
			}
			
			for(int i = 3; i <= Math.sqrt(n); i += 2){
				
				while(n%i == 0){
					n /= i;
					maxPrime = i;
				}
			}
			/*This is to handle the case when n is a prime number greater than 2*/
			if(n>2){
				System.out.println(n);
			}
		}
	}
}
