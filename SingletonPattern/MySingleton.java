public class MySingleton{
  public static void main(String[] args){
    Singleton obj1 = Singleton.getInstance();
    Singleton obj2 = Singleton.getInstance();
  }
}

class Singleton{
  private static Singleton obj = new Singleton();
  
  private static Singleton(){}
  
  public static Singleton getInstance(){
    return obj;
  }
}
