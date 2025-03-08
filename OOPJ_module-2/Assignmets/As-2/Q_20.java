/*
 *Q20: Implement a Java program that returns the absolute value of a given number using
the ternary operator (without using Math.abs()).
 */
import java.util.*;
class Absolute{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter number: ");
		int a=obj.nextInt();

                int res=(a>0)?a:-a;
		System.out.println("Absolute value: "+res);
	}

}
