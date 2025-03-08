/*
 *Q19: Write a Java program that checks whether a character is uppercase, lowercase, or
not a letter using only the ternary operator.
 *
 */
import java.util.Scanner;
class CheckLetters{
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Character: ");
		char ch=obj.next().charAt(0);

		System.out.println( ((ch>=65 && ch<=90)? ch+ " Is UpperCsae Letter" : (ch>=97 && ch<=123)?ch+" is LowerCase letter": " Is Not A Alphabet"));
	}

}
