/*Write a program that takes three boolean inputs and prints true
 * if at least two of them are true
 */
import java.util.*;
class BooleanCheck{

	public static void main(String[]args){
		
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the first Boolean Value: ");
		boolean first=obj.nextBoolean();
		System.out.println("Enter the second Boolean Value: ");
                boolean second=obj.nextBoolean();
		System.out.println("Enter the third Boolean Value: ");
                boolean third=obj.nextBoolean();


		if((first && second) || (second && third) || (third && first)){
			System.out.println(true);
		}else{
			System.out.println(false);
		}


		
	}
}



