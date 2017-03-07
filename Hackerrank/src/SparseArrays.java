package shiv;

import java.math.BigInteger;
import java.util.Scanner;

public class SparseArrays {

	public static void main(String[] args) {
		int _count = 0;
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] str = new String[N];
		
		for(int i = 0 ; i < N; i++){
			str[i] = sc.next();
		}
		//Query String
		int Q = sc.nextInt();
		String[] q_str = new String[Q];
		for(int i = 0; i < Q; i++){
			q_str[i] = sc.next();
		}
		
		for(int i = 0; i < Q; i++){
			for(int ii = 0; ii < N; ii++){
				if(str[ii].equals(q_str[i])){
					_count++;
				}
			}
			System.out.println(_count);
			_count = 0;
		}
		
	}

}
