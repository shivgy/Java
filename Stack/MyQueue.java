pubilc class MyQueue<T>{
  //Sub Class
  private static class QueueNode<T>{
    private T data;
    private QueueNode<T> next;
    
    //Constructor of sub class
    public QueueNode(T data){
      this.data = data;
    }
  }
  
  private QueueNode<T> first;
  private QueueNode<T> last;
  
  public void add(T item){
    QueueNode<T> t = new QueueNode<T>(item);
    if(last != null){
      last.next = t;
    }
    last = t;
    if(first == null){
      first = last;
    }
  }
  
  
}
