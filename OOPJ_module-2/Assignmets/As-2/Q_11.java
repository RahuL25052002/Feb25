/*
 *Q11: Write a program to check if a given number is a power of 2 using bitwise operators.
Hint: n & (n - 1) == 0 for positive numbers.

 */
import java.util.Scanner;
class powerOf{

	public static void main(String []args){
		Scanner obj=new Scanner(System.in);
		
		System.out.println("Enter a number");
		int num=obj.nextInt();
		if((num & (num-1))==0){
			System.out.println(num+" is power of 2");
		}else{
			System.out.println(num+" is not power of 2");
		}

	}
}
