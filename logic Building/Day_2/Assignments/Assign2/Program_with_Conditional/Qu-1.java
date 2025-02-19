/*Question 1: Grade Classification
Write a program to classify student grades based on the following criteria:
 If the score is greater than or equal to 90, print "A"
 If the score is between 80 and 89, print "B"
 If the score is between 70 and 79, print "C"
 If the score is between 60 and 69, print "D"
 If the score is less than 60, print "F"
*/

import java.util.*;
class Grade{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter Mark: ");
		int mark=obj.nextInt();
		if(mark>=90){
			System.out.println("Your Grade is: 'A' ");
		}else if(mark<90 && mark >80){
			System.out.println("Your Grade is: 'B' ");
		}else if(mark<80 && mark>70){
			System.out.println("Your Grade is: 'C' ");
		}else if(mark<70 && mark >60){
			System.out.println("Your Grade is: 'D' ");
		}else{
			System.out.println("Your Grade is: 'F' ");
		}
		
				
	}
}