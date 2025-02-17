import java.util.*;

class AverageOfThree{
	public static void main(String []args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter First number: ");
		int a=obj.nextInt();
		System.out.println("Enter Second number: ");
		int b=obj.nextInt();
		System.out.println("Enter Third number: ");
		int c=obj.nextInt();
		double avg=(double)(a+b+c)/(double)3;
		System.out.println("The average is: "+avg);
	}
}