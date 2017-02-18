import java.util.Scanner;

/**
 * @Author: Shiv Gopal Yadav
 * Date: 17-02-2017
 */


public class A{
	
	public static void main(String[] args){  Scanner in = new Scanner(System.in);
    int arr[][] = new int[6][6];
    for(int arr_i=0; arr_i < 6; arr_i++){
        for(int arr_j=0; arr_j < 6; arr_j++){
            arr[arr_i][arr_j] = in.nextInt();
        }
    }
    System.out.println(sum(arr));;
}

public static int sum(int[][] arr){
    int sum = -1000;
    for(int i = 0; i < 4; i++){
        for(int j = 0; j < 4; j++){
            
            int top = arr[i][j]+arr[i][j+1]+arr[i][j+2];
            int middle = arr[i+1][j+1];
            int bottom = arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
            
            if((top + middle + bottom)>sum){
                sum = top + middle + bottom;
            }
        }
    }
    return sum;
}
}
 
