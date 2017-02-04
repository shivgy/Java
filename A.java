public class A {
	
	B obj = new B();// Initializing object of Class B
	
	public static void main(String[] args){
		A t = new A(); //Instance of class A
		t.obj.m1();//calling method of class B
	}
	
	void m(){
		System.out.println("Method inside class A");
	}
}

class B{
	void m1(){
		System.out.println("Method inside class B");
	}
}
