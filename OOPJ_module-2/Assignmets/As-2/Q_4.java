/*
 *Q4: Write a program to find whether a given number is divisible by 3 without using the
modulus (%) or division (/) operators.
Hint: Use subtraction and bitwise shifts
 *
 */
import java.util.Scanner;
class DivisionBy3{
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int num=obj.nextInt();
		int temp=num;
		boolean isCheck=false;
		while(num>=3){
			if(num==3){
			
				System.out.println(temp+" is divisible by 3");
				isCheck=true;
				break;

			}
			num-=3;
		}
		if(!isCheck){
			System.out.println(temp+" is Not divisible by 3");
		}
	}
}
