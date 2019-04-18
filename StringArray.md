# Ways to declare String Array
A String array can be declared as ```String[] strArr = null;``` Provided, this reference variable is pointing a well defined string array.

**Incorrect way**
```
String[] strArray = null;
for(int i = 0; i < 10; i++){
  strArray[i] = "a"+i;
}
```
This will throw nullPointer exception

**Correct way**
```
String[] strArray = null;
String[] strArray1 = {"Shiv", "Umar","Satya","Abhishek"};
strArray = strArray1;
```
