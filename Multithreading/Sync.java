public class Sync.java{
  public static void main(String[] args){
    PrintDemo pdemo = new PrintDemo();
    ThreadDemo td1 = new ThreadDemo("Thread-1 ", pdemo);
    ThreadDemo td2 = new ThreadDemo("Thread-2 ", pdemo);
    td1.start();
    td2.start();
  }
}

class PrintDemo{
  public void printDemo(){
    try{
      for(int i = 1; i <= 10; i++){
        System.out.println(5*i);
        Thread.sleep(1000);
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}

class ThreadDemo extends Demo{
  String name;
  PrintDemo pd;
  
  ThreadDemo(String name, PrintDemo pd){
    this.name = name;
    this.pd = pd;
  }
  
  public void run(){
    pd.printDemo();
  }
}
