import java.util.*;

class LargestOfThreeNumber{
	public static void main(String [] args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter First number: ");
		int a=obj.nextInt();
		System.out.println("Enter Second number: ");
		int b=obj.nextInt();
		System.out.println("Enter Third number: ");
		int c=obj.nextInt();

		if(a>=b && a>=c){
			System.out.println("The largest Number is "+a);
		}else if(b>=a && b>=c){
			System.out.println("The largest Number is "+b);
		}else{
			System.out.println("The largest Number is "+c);	
		}
	

	}
}