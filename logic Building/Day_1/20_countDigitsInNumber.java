import java.util.*;
class CountDigitsInNumber{
	public static void main(String[] args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the Number: ");
		int a=obj.nextInt();
		int temp=a;
		int count=0;
		while(a!=0){
			count++;
			a=a/10;
		}
		System.out.println("The Number "+temp+" has "+count+" digits");
		
	}
}