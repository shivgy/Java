public class Reverse{

import java.util.Scanner;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    int reverse = 0;
    
    while(number/10 != 0){
      reverse += number%10;
      reverse *= 10;
      number /= 10;
    }
    reverse += number;
    System.out.println(reverse);
  }
