/*
 *Q22: Implement a calculator that takes two numbers and an operator (+, -, *, /) as input
and prints the result using only switch-case
 */
import java.util.Scanner;
class Calculator{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter first Number: ");
		int a=obj.nextInt();
		System.out.println("___________");
		System.out.print("Enter Second Number: ");
		int b=obj.nextInt();
		System.out.println("-----------");
		System.out.println("Enter the operation (+,-,*,/): ");
		char ch=obj.next().charAt(0);
		
		switch(ch){
			case '+':
				System.out.println("Addition of "+a+" and "+b+" is: "+(a+b));
				break;
			case '-':
				System.out.println("Subtraction of "+a+" and "+b+" is: "+(a-b));
                                break;
			case '*':
				System.out.println("Multiplication of "+a+" and "+b+" is: "+(a*b));
                                break;
			case '/':
				double res=(double)a/b;
				System.out.println("division of "+a+" and "+b+" is: "+res);
                                break;
			default:
				System.out.println("You enter Wrong input for operation");
		}


	}

}
