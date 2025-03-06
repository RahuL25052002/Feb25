/*
 *Vowel or consonant
 *
 */
import java.util.*;
class Q_10{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		char []vowel={'a','A','e','E','I','i','o','O','u','U'};
		System.out.println("Enter Char: ");
		char ch=obj.next().charAt(0);
		
		boolean isCheck=false;
		for(char check:vowel){
			if(check==ch){
				System.out.println(ch+" is Vowel");
				isCheck=true;
				break;
			}
		}
		if(!isCheck){
			System.out.println(ch+" is Consonant");
		}
	}

}


