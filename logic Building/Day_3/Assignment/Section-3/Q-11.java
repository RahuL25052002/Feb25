//11. Write a Java program to demonstrate the use of both pre-increment and post-decrement operators in a single expression

class IncDec{
	public static void main(String[]args){
		int x=2;
		int y=3;
		int z=++x + --y + y++ + x++ + ++y;
		System.out.println("x is "+x);
		System.out.println("y is "+y);
		System.out.println("z is "+z);			
	}
}