/*
 *implement a java program that checks if a number is within a specific range (20 to
50) without using if-else .
Hint : Use logical AND ( && ) in a print statement .
 */



import java.util.Scanner;

class Test{
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter Number: ");
		int x=obj.nextInt();
		System.out.println((x>=20 && x<=50) ? x+" is within a range" :x+" is not in range");
	}
}

