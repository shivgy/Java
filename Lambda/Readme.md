# Lambda Expression
* A Lambda expression is a function which can be created without belonging to any class.
* It can be passed around as an object and executed on demand.
* It provides clear and concise way to represent one method interface using an expression.
* Before _Lambda Expression,_ anonymous inner class was the only option to implement the method.

## Without Lambda Expression
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
  }
}
```
