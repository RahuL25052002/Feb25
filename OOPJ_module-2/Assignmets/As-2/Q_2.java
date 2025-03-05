/*
 *Q2: Write a program to check whether a given number is even or odd using only bitwise
operators.
Hint: Use n & 1 to check.

 *
 */
import java.util.Scanner;
class EvenorOdd{
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int a=obj.nextInt();

		if((a&1)==1){
			System.out.println(a+" is Odd Number");
		}else{
			System.out.println(a+" is Even Number");
		}

		
	}
}
