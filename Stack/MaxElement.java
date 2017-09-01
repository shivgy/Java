package stack;

import java.util.Scanner;
import java.util.Stack;

public class TestSolution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Stack<Integer> myStack = new Stack<>();
		Stack<Integer> maxStack = new Stack<>();
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++){
			int r = sc.nextInt();
			if(r == 1){
				myStack.push(sc.nextInt());
				if(maxStack.isEmpty()) maxStack.push(myStack.peek());
				else if(maxStack.peek()<=myStack.peek()){
					maxStack.push(myStack.peek());
				}
			}else if(r == 2){
				if(myStack.peek() == maxStack.peek()){
					myStack.pop();
					maxStack.pop();
				}else{
					myStack.pop();
				}
			}else if(r == 3){
				System.out.println(maxStack.peek());
			}
		}//For loop ends
		
		
	}
}
