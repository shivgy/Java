/*
 *
 * Can two instances of MyClass can call foo at the same time?
 * It depends. If they have the same instance of MyObject. then No
 * But if they hold different references, then the answer is yes.
 */

public class CrackingCode{
  public static void main(String[] args){
    MyObject obj1 = new MyObject();
    MyClass t1 = new MyClass("Thread-1", obj1);
    MyClass t2 = new MyClass("Thread-2", Obj1);
    t1.start();
    t2.start();
  }
}

class MyClass extends Thread{
  String name;
  MyObject obj;
  
  /* This construct is important, don't know why.
   * Else, it will throw NullPointerException
   */
  MyClass(String name, MyObject obj){
    this.name = name;
    this.obj = obj;
  }
  
  public void run(){
    obj.foo(name);
  }
}

class MyObject{
  public synchronized void foo(String name){
    try{
      System.out.println("Thread name: " + name + " .foo() started");
      Thread.sleep(3000);     //Sleeps for 3 seconds
      System.out.println("Thread name: " + name + " .foo() ended");
    }catch(InterruptedException e){
      System.out.println("Thread name: " + name + " interrupted");
    }
  }
}
