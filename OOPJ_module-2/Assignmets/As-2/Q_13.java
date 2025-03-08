/*
 *Q13: Implement a Java program to find the absolute value of an integer using bitwise
operators.
Hint: mask = num >> 31; abs = (num + mask) ^ mask;
 *
 */
import java.util.Scanner;
class AbsoluteValue{
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int a=obj.nextInt();

		int mask=a>>31;
		int abs=(a+mask)^mask;
		System.out.println("Absolute value 0f "+a+" is "+abs);
	}
}
