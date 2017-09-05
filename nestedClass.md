# Nested Class

* In java, just like methods, variable of a class too can have another class as its member. 
* Writing a class within another class is allowed in java. 
* The class written within is called the nested class, and the class that holds the inner class is called outer class. 
* Inner class are a security mechanism in java. 

```
public class A{
  public class B{
    void msg(){
      System.out.println("I am inside nested class B");
    }
  }
  
  public static void main(String[] args){
    A obj = new A();
    A.B new_obj = obj.new B();
    new_obj.msg();
  }
}
```
Because the nested class is `public` it can be accessed from outside the outer class. Following example illustrates this:

```
public class A{
  public class B{
    void msg(){
      System.out.println("Inside nested class B this will be accessed outside the outer class");
    }
  }
  
  public static void main(String[] args){
    C obj1 = new C();
    obj1.prin();
  }
}

class C{
  void prin(){
    A obj = new A();
    A.B nested_obj = obj.new B();
    nested_obj.msg();
  }
}
```

## Nested Class with `private` access modifier
We know a class cannot be associated with the access modifier private, but if we have the class as a member of other class, then the inner class can be made private, and this is also used to access the private member of a class. Unlike a class, an inner class can be private and once you declare an inner class private, it cannot be accessed from an object outside the class. 

```
public class A{
  
  private class B{
    //This class cannot be accessed from an object outside the class
    void msg(){
      System.out.println("Inside nested class B with private access modifier");
    }
  }
  
  public static void main(String[] args){
    C obj1 = new C();
    obj1.prin();  //-------->>>> This will throw error on execution as, Class is B is made private.
  }
}

class C{
  void prin(){
    A obj = new A();
    A.B nested_obj = obj.new B();
    nested_obj.msg();
  }
}
```

## Nested Class with `static` keyword
In Java, we have static instance variables as well as static methods and also static block. 
Classes can also be made static in Java. Here, we can’t make top level class static. Only nested classes can be static. 

**Note :** Nested static class doesn't need reference of Outer class.
```
public class A{
  private static class B{
    void msg(){
      System.out.println("Inside nested class B this will be accessed outside the outer class");
    }
  }
  
  public static void main(String[] args){
    B obj = new B();
    obj.msg();
  }
}
```

## Difference between static and non-static nested classes:
1. Nested static class doesn’t need reference of Outer class, but non-static nested class or inner class require Outer class reference.
2. Inner class (or non-static nested class) can access both static and non-static members of outer class. A static class cannot access non-static members of the outer class. It can access only static members of outer class.
3. An instance of Inner class cannot be created without an instance of outer class and an inner class can reference data and methods defined in Outer class in
which it nests, so we don’t need to pass reference of an object to the constructor of the inner class. For this reason inner classes can make program simple and concise.
