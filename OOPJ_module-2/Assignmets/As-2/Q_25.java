/*
 *Q25: Implement a program that reverses an integer number without using string
conversion (StringBuilder or toCharArray).
Hint: Use while(n!=0) { rev = rev * 10 + n % 10; n /= 10; }
 */
import java.util.Scanner;
class  Reverse{

	static int reverse(int num){
		int rev=0;
		while(num!=0){
			rev=rev*10+num%10;
			num=num/10;
		}
		return rev;
	}
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter a Number: ");
		int num=obj.nextInt();
		int ans=reverse(num);
		System.out.println("Reverse of "+num+" is = "+ans);
	}

}

