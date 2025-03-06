/*
 *Q6: Write a program to find the largest of three numbers using only the ternary operator
(? :).

 */
import java.util.*;
class LargestAmongThree{
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the number1: ");
		int a=obj.nextInt();
	        System.out.println("Enter the number2: ");
                int b=obj.nextInt();
		System.out.println("Enter the number3: ");
                int c=obj.nextInt();

		String max=(a>=b && a>=c)? a+" is Larger" :(b>=c && b>=a) ? b+" is Larger" : c+" is Larger";

		System.out.println(max);
	}
}
