import java.util.*;
class ReverseNumber{
	public static void main(String[] args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int a=obj.nextInt();
		int temp=a;
		int rev=0;
		while(a!=0){
			rev=rev*10+a%10;
			a=a/10;
		}
		System.out.println("The reverse of "+temp+" is "+rev);
		
	}
}