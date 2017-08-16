# Lambda Expression
* A Lambda expression is a function which can be created without belonging to any class.
* It can be passed around as an object and executed on demand.
* It provides clear and concise way to represent one method interface using an expression.
* Before **_Lambda Expression,_** anonymous inner class was the only option to implement the method.

## Without Lambda Expression
**Note:** The interface is not implemented in the main class(LambdaExpressionExample). Rather, while instantiating, the unimplemented method is defined there itself. If the interface contains more than one method all the methods must be defined in there.

This will be cumbersome so we implement the interface calss.
```
interface Drawable{
  public void draw();
}

public LambdaExpressionExample{
  public static void main(String[] args){
    int width = 10;
    Drawable d = new Drawable(){
       public void draw(){
        System.out.println("Drawing " + width);
       }
    };
    d.draw();
  }
}
```
## Using Lambda Expression
**Note:** Only single method is present in the interface where we use Lambda Expression.
```
interface Drawable{
  public void draw();
}

public class LambdaExpressionExample{
  public static void main(String[] args){
    int width = 10;
    Drawable d = ()->{
      public void draw(){
        System.out.println("Drawing " + width);
      }
    };
  }
}
```
