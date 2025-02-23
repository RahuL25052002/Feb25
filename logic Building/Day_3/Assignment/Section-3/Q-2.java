//2. Write a program to compute the factorial of the number 10.

class Factorial10{
	public static void main(String[]args){
		int fact=1;
		for(int i=10;i>0;i--){
			fact=fact*i;
		}
		System.out.println("factorial of the number 10 is: "+fact);		
	}
}

// o/p:factorial of the number 10 is: 3628800