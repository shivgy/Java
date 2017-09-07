# Performing add/remove operation on an Array

Since we know Arrays have fixed size at the time of initialization therefore, the question arises:

**Why would you choose an Array to perform this operation when you have Collection (LinkedList, ArrayList, etc. ) which is a better option?**

Because, I have an array which is coming in as input and going out and in between I have do the processing.

## Solution

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
