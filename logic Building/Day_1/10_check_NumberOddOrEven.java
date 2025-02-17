import java.util.*;
class IsOddOrEven{
	public static void main(String[] args){
		Scanner obj=new  Scanner(System.in);
		System.out.println("Enter the Number: ");
		int a=obj.nextInt();
		if(a%2==0){
			System.out.println("The number "+a+" is Even");
		}else{
			System.out.println("The number "+a+" is odd");
		}
	}
}