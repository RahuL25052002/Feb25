/*
Write a Java program to print the sum, multiplication, subtraction, division, and remainder of two numbers.
Test Data:
 Input first number: 125
 Input second number: 24
Expected Output:
125 + 24 = 149
125 - 24 = 101
125 x 24 = 3000
125 / 24 = 5
125 mod 24 = 5

*/

class Operations{
	public static void main(String[] args){
		int a=125;
		int b=23;
		int add=a+b;
		int sub=a-b;
		int mult=a*b;
		double div=(double)a/b;
		int md=a%b;
		System.out.println(add);
		System.out.println(sub); 
		System.out.println(mult); 
		System.out.println(div); 
		System.out.println(md);  
	}	
}

