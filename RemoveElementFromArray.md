# Performing add/remove operation on an Array

Since we know Arrays have fixed size at the time of initialization therefore, the question arises:

**Why would you choose an Array to perform this operation when you have Collection (LinkedList, ArrayList, etc. ) which is a better option?**

Because, I have an array which is coming in as input and going out and in between I have do the processing.
## Solution 1 : Naive Approach

```
public static void main(String args[])
   {
       int size, i, del, count=0;
       int arr[] = new int[50];
       Scanner sc = new Scanner(System.in);
	   
       System.out.println("Enter Array Size : ");
       size = sc.nextInt();
	   
       System.out.println("Enter Array Elements : ");
       for(i=0; i<size; i++)
       {
           arr[i] = sc.nextInt();
       }
	   
       System.out.println("Enter Element to be Delete : ");
       del = sc.nextInt();
       for(i=0; i<size; i++)
       {
           if(arr[i] == del)
           {
               for(int j=i; j<(size-1); j++)
               {
                   arr[j] = arr[j+1];
               }
               count++;
               break;
           }
       }
       if(count==0)
       {
           System.out.println("Element Not Found..!!");
       }
       else
       {
           System.out.println("Element Deleted Successfully..!!");
           System.out.println("\nNow the New Array is :\n");
           for(i=0; i<(size-1); i++)
           {
               System.out.println(arr[i]+ " ");
           }
       }
   }
```
## Solution 2

*	Given Array

```
String[] array = {“a”, “b”, “c”, “d”, “e”, “f”,};
```
*	Declare an empty array `String[] EMPTY_STRING = new String[0]`

*	Convert the incoming array into List by adding all the elements of array into list.

```
List<String> list = new ArrayList<>();
boolean b = Collections.addAll(list, array);
```
*	Perform the operation

```
list.removeAll();
```
*	Convert the list back into Array

```
array = list.toArray(EMPTY_STRING);
```
