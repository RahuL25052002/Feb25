import java.util.*;
class fact{
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter a number: ");
		int a=obj.nextInt();
		int factNum=1;
		for(int i=1;i<=a;i++){
			factNum*=i;
		}
		System.out.println("Factorial of "+a+" is "+factNum);

	}
}