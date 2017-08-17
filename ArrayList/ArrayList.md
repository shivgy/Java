# How to reverse ArrayList in java ?
Array List can be reversed using ```reverse()``` method of ```java.util.Collections```. Find below a sample example:

```
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListReverseDemo{
  public static void main(String[] args){
    ArrayList<String> listOfInts = new ArrayList<String>();
    
    listOfInts.add("1");
    listOfInts.add("2");
    listOfInts.add("3");
    listOfInts.add("4");
    listOfInts.add("5");
    
    Collections.reverse(listOfInts);
  }
}
```

# How to synchronize ArrayList in java?
ArrayList is not synchronized which means, it cannot be used in multithreading or it is not thread-safe. 
But, there is a way to synchronize the ArrayList using ```synchronizedList()``` method

# How to remove objects from ArrayList in java?
