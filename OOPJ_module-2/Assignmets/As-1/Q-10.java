
//11. Write a program to check if a number is positive and even using logical operators (&&, ||, !).

import java.util.Scanner;
class Test{
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int a=obj.nextInt();
		if((a%2==0) && a>=0){
			System.out.println("Number is Positive and Even");
		}else if((a%2!=0) || a>=0){
			System.out.println("Number is Postive and Odd");
		}
	}

}

