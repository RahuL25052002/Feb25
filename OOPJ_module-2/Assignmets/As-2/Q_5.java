/*
 Q5: Write a Java program to swap two numbers using the += and -= operators only
 *
 */
import java.util.Scanner;
class Swapping{
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Number 1: ");
		int num1=obj.nextInt();
		System.out.println("Enter the Number 2: ");
		int num2=obj.nextInt();

		num1=num1+num2;
		num2=num1-num2;
		num1=num1-num2;

		System.out.println("After Swapping: ");
		System.out.println("Number 1: "+num1);
		System.out.println("Number 2: "+num2);
	}
}
