
public class ExtendThread{
  public static void main(String[] args){
    ThreadExample instance = new ThreadExample();
    instance.start();
    
    while(count < 5){
      try{
        Thread.sleep(250);
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    
  }
}

class ThreadExample extends Thread{
  public int count = 0;
  
  public void(){
    try{
      System.out.println("Thread started. Thread Id: " + Thread.currentThread.getId());
      while(count < 5){
        Thread.sleep(500);
        count++;
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.println("Thread terminated. Thread Id: " + Thread.currentThread.getId());
  }
}
