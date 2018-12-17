# Print the individual occurance of elements 
##  Consider the given input stream is in sorted order.

1. Use **Scanner** class to read the input stream.
> Scanner sc = new Scanner(System.in);

2. Read the input stream into a String variable.
> String str = sc.nextLine();

3. Convert the given String into an array. Use For loop.

```
String[] strArray = new String[str.length()];
for(int i = 0; i<strArray.length; i++)
{
  strArray[i] = str.subString(i,i+1);
}
```
4. Declare a temporary variable to store the individual element.

5. Use a *for-loop* to iterate all the elements of the Array. Use *while-loop* inside *for-loop* to count the Occurance.

```
  String temp;
		for(int i = 0; i < strArr.length; i++)
		{
			int charCount = 0;
			temp = strArr[i];
			while((i+charCount)<strArr.length &&strArr[i+charCount].equals(temp))
			{
				charCount++;
			}
			System.out.print(temp+""+charCount);
			i+=charCount-1;
		}
```
