package shiv;

import java.util.Scanner;

public class EvenFibonacci {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long N;
		
		
		for(int i = 0; i < t; i++){
			long b = 1;
			long fib = 2;
			long sum = 2;
			
			N = in.nextLong();
			
			while(fib<=N){
				
				fib += b;
				b = fib - b;
				if(fib < N && fib%2 ==0){
					sum += fib;
				}
			}
			System.out.println(sum);
		}
	}
}
