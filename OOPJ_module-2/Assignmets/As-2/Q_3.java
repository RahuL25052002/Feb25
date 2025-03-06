/*
 *Q3: Implement a program that calculates the sum of digits of an integer using modulus
(%) and division (/) operators.

 */

import java.util.Scanner;

class SumOfDigits{
	public static void main(String[]args){

		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int num=obj.nextInt();
		int sum=0;
		int temp=num;
		while(num!=0){
			sum=sum+num%10;
			num=num/10;
		}

		System.out.println("The sum "+temp+" digits is= "+sum);
	}
	
}
