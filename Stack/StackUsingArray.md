# Implement Stack using an Array
The bottleneck in implementing stack using Array, the size of array.

```
public class StackDemo{
  private static final int size = 10;
  public int[] array = new int[size];
  public int count = -1;
  
  public static void main(String[] args){
  
  }
  
  void push(int data){
      if(count < size-1){
        count++;
        array[count] = data;
      }else{
        throw new StackOverflowError("Stackoverflow");
      }
  }
  
  void pop(){
    if(count >= 0){
      count--;
    }
    else{
      throw new EmptyStackException();
    }
  }
  
  void peek(){
    if(count >= 0){
      System.out.println(array[count]);
    }
  }
  
  void printElement(){
    if(count >= 0){
      for(int i = 0; i < count; i++){
        System.out.println(array[i]);
      }
    }
    else{
        System.out.println("Empty Stack");
    }
  }
}
```
