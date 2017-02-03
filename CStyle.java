public class CStyle {

	public static void main(String[] args) {
		char str2[] = {'h','e','l','l','o','\0'}; //C-style string

		hash(str2);
		System.out.println(hash(str2));
	}
	
  /* Method to return the length of input character string*/
	public static int hash(char str[]){
		return str.length;
	}

}
