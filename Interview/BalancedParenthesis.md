# Balanced Parenthesis

1. Create a function which returns boolean true/false `public static boolean isParenthesis(String str)`
2. Declare a stack to store the parenthesis.
3. Use `for` loop to scan the complete string for each character present.
4. In case open brace is encountered, *push* it into the stack.
5. In case closed brace is encountered, check the top element in stack the closing brace should correspond to its counter open brace.If matched *pop* the stack and continue else return *false*


```
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Parenthesis
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of test cases: ");
		int num = Integer.parseInt(br.readLine());
		while(num > 0)
		{
			System.out.println(num-- + "Chances Left");
			String str = br.readLine();
			if(isParenthesis(str))
				System.out.println("Cool Shiv");
			else
				System.out.println("Poor Shiv");
		}
	}
	
	public static boolean isParenthesis(String str)
	{
		Stack<Character> stack = new Stack<Character>();
		char c;
		
		for(int i = 0; i < str.length(); i++)
		{
			c = str.charAt(i);
			if(c == '(')
				stack.push(c);
			else if(c == '{')
				stack.push(c);
			else if(c == '[')
				stack.push(c);
			else if(c == ')')
			{
				if(stack.isEmpty())
					return false;
				else if(stack.peek() == '(')
					stack.pop();
				else
					return false;
			}
			else if(c == '}')
			{
				if(stack.isEmpty())
					return false;
				else if(stack.peek() == '{')
					stack.pop();
				else
					return false;
			}
			else if(c == ']')
			{
				if(stack.isEmpty())
					return false;
				else if(stack.peek() == '[')
					stack.pop();
				else
					return false;
			}
		}
		return stack.empty();
	}
}

```
