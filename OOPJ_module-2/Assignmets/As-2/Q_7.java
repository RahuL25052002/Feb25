/*
 * Q7: Implement a Java program that checks whether a given year is a leap year or not using
logical (&&, ||) operators
 *
 */

import java.util.Scanner;

class LeapYear{
	public static void main(String[]args){

		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Year: ");

		int year=obj.nextInt();



		if((year%4==0 || year%400==0) && year%100!=0){
			System.out.println(year+" is Leap Year");
		}else{
			System.out.println(year+" is not a Leap Year");
		}
	}
}
