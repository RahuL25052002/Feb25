/*
Question 2: Days of the Week
Write a program that uses a nested switch statement to print out the day of the week based on an
integer input (1 for Monday, 2 for Tuesday, etc.). Additionally, within each day, print whether it
is a weekday or weekend.
*/

import java.util.*;
class week{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter Number : ");
		int num=obj.nextInt();
		switch(num){
			case 1:
				System.out.println("Its 'Monday' (Weekday) ");
				break;	
			case 2:
				System.out.println("Its 'Tuesday' (Weekday) ");	
				break;
			case 3:
				System.out.println("Its 'Wednesday' (Weekday) ");	
				break;	
			case 4:
				System.out.println("Its 'Thursday' (Weekday) ");		
				break;
		
			case 5:
				System.out.println("Its 'Friday' (Weekday) ");	
				break;

			case 6:
				System.out.println("Its 'Saturday' (Weekend) ");	
				break;
			case 7:
				System.out.println("Its 'Sunday' (Weekend) ");	
				break;
			default:
				System.out.println("You enter Wrong input!!!");
				break;	
		}
	}
}