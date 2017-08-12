public class MyStack<T>{
  
  //sub-class
  private static class StackNode<T>{
    private T data;
    private StackNode<T> next;
    
    //Constructor
    public StackNode(T data){
      this.data = data;
    }
  }
  
  private StackNode<T> top; //A variable declared of data type StackNode
  
  public T pop(){
    if(top == null) throw  new EmptyStackException();
    T item = top.data;
    top = top.next;
    return item;
  }
  
  public void push(T item){
    StackNode<T> t = new StackNode<T>(item);
    t.next = top;
    top = t;
  }
  
  public T peak(){
    if(top == null) throw  new EmptyStackException();
    return top.data;
  }
  
  public boolean isEmpty(){
    return top == null;
  }
}
