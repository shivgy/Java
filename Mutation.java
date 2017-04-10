public class Mutation {
	
	public static void main(String[] args){
		String a = "a";
		System.out.println("a 1--->>>" + a);
		
		String b = a;//Assigning reference of a into b
		
		a = "ty"; //A new memory will be allocated for literal 'ty' with same reference as a
		
		System.out.println("a 2 --->>>" + a);
		
		System.out.println("b --->>>" + b);
	
	}
}
