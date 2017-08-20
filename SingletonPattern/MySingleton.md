# Singleton Class
It is a class which can have only one instance. It is a two step process to make a class restricted for not having more than one instance and provide a global point of access to it.

step 1. Make sure that there is only one instance:
        restrict construction - make constructor **private** and let the class manage its instance

step 2. Provide a global point of access: a static method to get the sole instance.

Here we can not use **new** keyword to create an object of singleton class. Therefore, we will use a method _getInstance()_ to access the instance of the Singleton class.

```
public class SingletonExample{
  public static void main(String[] args){
    Singleton obj1 = Singleton.getInstance();
    Singleton obj2 = Singleton.getInstance();
    //These two objects are same. It can be verified by their HashCode.
    //Let us print the hashcode of the two object using print method
    
    System.out.format("Object 1, HashCode : " + obj1.hashCode());
    System.out.format("Object 2, HashCode : " + obj2.hashCode());
    
    //If there are two instances then there should be two hashCodes.
  }
}

class Singleton{
  private static Singleton obj = new Singleton();
  
  private Singleton(){}
  
  public static Singleton getInstance(){
    return obj;
  }
}
```
