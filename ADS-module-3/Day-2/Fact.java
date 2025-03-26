class Fact{
	static int fact(int n){

		if(n<=1){
			return 1;
		}
		return n*fact(n-1);
	}
	public static void main(String[]args){
		          System.out.println("Factorial of 0: "+fact(0));
		System.out.println("Factorial of 4: "+fact(4));
		System.out.println("Factorial of 5: "+fact(5));
		System.out.println("Factorial of 6: "+fact(6));
	}

}

