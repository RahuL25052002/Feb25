/*
 *
 * Q23: Given a number, find whether it is odd or even using the & bitwise operator and print
the result without using if-else
 */

class OddEven{

	public static void main(String[]args){

		int a=4;
		System.out.println((a&1)==0? a+" is Even":a+" is Odd");
	}
}
