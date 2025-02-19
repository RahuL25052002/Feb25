/*
Question 3: Calculator
Write a program that acts as a simple calculator. It should accept two numbers and an operator
(+, -, *, /) as input. Use a switch statement to perform the appropriate operation. Use nested ifelse
to check if division by zero is attempted and display an error message.
*/

import java.util.*;
class Cal{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter first Number : ");
		int a=obj.nextInt();
		System.out.println("Enter second Number : ");
		int b=obj.nextInt();
		System.out.println("Enter (+, -, *, /) which operation you have to done :  ");
		String op=obj.next();
		switch(op){
			case "+":
				
				System.out.println("Addition of "+a+" and "+b+" is : "+ (a+b));
				break;	
			case "-":
				System.out.println("Subtraction of "+a+" and "+b+" is : " +( a-b));	
				break;
			case "*":
				System.out.println("Multiplication of "+a+" and "+b+" is : "+ (a*b));	
				break;	
			case "/":
				if(b==0){
					System.out.println("You give an zero we Cannot divide by zero");
					break;
				}else{
				
					System.out.println("Division of "+a+" and "+b+" is : "+ (a/b));	
					break;
				}
	
			default:
				System.out.println("You enter Wrong input!!!");
				break;	
		}
	}
}