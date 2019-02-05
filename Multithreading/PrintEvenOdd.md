# Print Even and Odd Numbers using two threads
Because two threads are going to be used in this exercise therefore:
```
Thread t1 = new Thread();
Thread t2 = new Thread();

t1.start();
t2.start();
```
Thread `t1` will print Odd Numbers hence name of Thread will be *'Odd'*. And Thread `t2` will print Even Numbers hence name of Thread will be *'Even'*.

*__Thread__ class extends __Object__ class and implements __Runnable__ interface*

`public class Thread extends Object implements Runnable`

#### __Remember__ Every thread execution begins as an instance of class Thread.Regardless of whether your run() method exists in a Thread subclass or a Runnable implementation class, you still need a Thread object to do the work.

* Default constructor of thread `Thread t1 = new Thread()` can be used when the `run()` method is present in the same class.
* Parameterized constructor of thread `Thread t1 = new Thread(Runnable targe, String name)` is used to create thread from Runnable object with thread name as second argument.
Therefore, instantiation of the two thread will be like:
```
Thread t1 = new Thread(new RunnableObject, "Odd");
Thread t2 = new Thread(new RunnableObject, "Even");
```
Odd thread will print Odd numbers and Even thread will print Even numbers.

### RunnableObject
__RunnableObject__ is the class where `run()` method is overriden and which implements __Runnable__ interface. RunnableObject is __TaskEvenOdd__

```
class TaskEvenOdd implements Runnable
{  
  public void run()
  {
    
  }
}
```
* Because two separate threads will be created on this object to print even and odd. Therefore, there should be a check to determine if it is creatd for even or odd.
* There should also be a check to stop executin the thread else it will go into infinite mode. Therefore, maximum number till where numbers has to be printed.
* For printing the even and odd numbers I should have a print object which defines two methods for even printing and odd printing.
```
class TaskEvenOdd implements Runnable
{
  private Printer print;
  private int max;
  private boolean isEvenNumber;
  
  //Parameterized Constructor
  TaskEvenOdd(Printer print, int max, boolean isEvenNumber)
  {
    this.print  = print;
    this.max = max;
    this.isEvenNumber = isEvenNumber;
  }

  public void run()
  {
    
  }
}
```
I have decided to implement `Runnable` interface in this exercise therefore, my `run()` method will look like:

```
public void run()
{
  if(isEvenNumber)
  {
    print.printEven(number);
  }
  else
  {
    print.printOdd(number);
  }
}
```

## Printer.java
```
public class Printer
{
	private volatile boolean isOdd;
	
	synchronized void printEven(int number)
	{
		while(!isOdd)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+":"+number);
		isOdd = false;
		notify();
	}
	
	
	synchronized void printOdd(int number)
	{
		while(isOdd)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+":"+number);
		isOdd= true;
		notify();
	}
}

```

## TaskEvenOdd.java
```
public class TaskEvenOdd implements Runnable
{
	private boolean isEvenNumber;
	private int max;
	private Printer print;
	
	
	TaskEvenOdd(Printer print, int max, boolean isEvenNumber)
	{
		this.print = print;
		this.max = max;
		this.isEvenNumber = isEvenNumber;	
	}
	
	public void run()
	{
		int number = isEvenNumber?2:1;
		
		while(number<max)
		{
			if(isEvenNumber)
			{
				print.printEven(number);
			}
			else
			{
				print.printOdd(number);
			}
			number += 2;
		}
	}
}

```

## Main.java
```
public class Main
{
	public static void main(String[] args)
	{
		
		Printer print  = new Printer();
		Thread t0 = new Thread();
		Thread t1 = new Thread(new TaskEvenOdd(print, 10, false), "Odd");
		Thread t2 = new Thread(new TaskEvenOdd(print, 10, true), "Even");
		t1.start();
		t2.start();
   }
 }
```
