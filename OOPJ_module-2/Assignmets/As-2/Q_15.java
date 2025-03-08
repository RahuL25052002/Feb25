/*
 *
 * Q15: Implement a program to swap odd and even bits of a number using bitwise
operators.
Hint: Use masks: (x & 0xAAAAAAAA) >> 1 | (x & 0x55555555) << 1
 */

class SwapOddEven{

	public static void main(String[]args){
		int x=9;
		int evnB=(x & 0xAAAAAAAA)>>1;
		int odB=(x & 0x55555555)<<1;
		int res=(evnB | odB);
		System.out.println(res);
	
	}

}
