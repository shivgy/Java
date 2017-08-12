// MyStack.java
// Implements a generic stack

public class MyStack<T> {
    private T[] theStack;
    private int numElements = 0;

    public MyStack(T[] t) {       // Constructor
       theStack=t;
      }

    public void push(T x) {
       theStack[numElements] = x;
       numElements++;
      }

    public T pop() {
       numElements--;
       return theStack[numElements];
     }

    public T top() {
       return theStack[numElements-1];
      }

    public boolean isEmpty() {
       return numElements == 0;
      }
}
