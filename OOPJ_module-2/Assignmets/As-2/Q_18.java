/*
 *Q18: Given a studen percentage, print pass  if the percentage is 40 or above;
otherwise, print Fail, using only the ternary operator.
 *
 */


import java.util.Scanner;
class Percent{

	public static void main(String[]args){
		
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Percentage: ");
		double val=obj.nextDouble();

		System.out.println((val>40.0)?"Pass":"Fail");
	
		
	}

}
