/*
 *Q12: Write a Java program to multiply a number by 8 without using * or / operators.
Hint: Use bitwise left shift (<<).

 */

import java.util.Scanner;
class multiplyby8{

	public static void main(String[]args){
		
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int a=obj.nextInt();

		int ans=a<<3;//simple logic 2^3=8 so by 3 shift to left we get answer
		System.out.println(ans+" is answer when multiply by 8");
	}

}
