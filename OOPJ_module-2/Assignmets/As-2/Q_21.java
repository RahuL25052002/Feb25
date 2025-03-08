/*Q21: Write a program that increments a number without using + or ++ operators.
Hint: Use bitwise - (~x).
 *
 */


import java.util.*;

class IncrementWithout{

	public static void main(String[]args){
		
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the Number: ");

		int b=obj.nextInt();
		System.out.println("How many times you want to increment number: ");
		int num=obj.nextInt();
		for(int i=0;i<num;i++){

			b=-(~b);

			System.out.println("The Value After Incrementing by "+(i+1) +"  is "+b);
		}

			
	}

}
