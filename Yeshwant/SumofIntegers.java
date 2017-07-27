public class SumofIntegers{
  
  import java.util.Scanner;
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    int sum = 0;
    while(number/10 != 0){
      sum += number%10;
      number /= 10;
    }
    sum += number;
    System.out.println(sum);
  }
}
