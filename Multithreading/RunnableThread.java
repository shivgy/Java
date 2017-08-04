
public class RunnableThread{
  public static void main(String[] args){
    RunnableThreadExample instance = new RunnableThreadExample();
    Thread thread = new Thread(instance);
    thread.start();
  }
}

class RunnableThreadExample implements Runnable{
  public int count = 0;
  
  public void run(){
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
