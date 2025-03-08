/*
 *Q14: Write a program to count the number of 1s (set bits) in a binary representation of a
number using bitwise operations.
Hint: Use n & (n - 1).

 *
 */

class CountBits{
	public static void main(String[]args){
		int a=5;
		int count=a&(a-1);
		System.out.println("Count of bits in "+a+" is= "+count);
	}

}
