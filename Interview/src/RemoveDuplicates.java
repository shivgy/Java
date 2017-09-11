import java.util.Scanner;
import java.util.ArrayList;

public class RemoveDuplicates {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < number; i++){
			list.add(sc.nextInt());
		}
		System.out.println(list.toString());
		
		for(int i = 0; i < list.size(); i++){
			for(int j = i+1; j < list.size(); j++){
				if(list.get(i).equals(list.get(j))){
					count++;
					if(count > 1){
						list.remove(j);
						j--;
					}
				}
			}
			count = 0;
		}
		System.out.println(list.toString());
	}
}
