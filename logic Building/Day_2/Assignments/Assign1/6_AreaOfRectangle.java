import java.util.*;
class CheckPositiveNumber{
	public static void main(String[] args){
		Scanner obj =new Scanner(System.in);
		System.out.print("Enter breadth: ");
		int b=obj.nextInt();
		System.out.print("Enter Length: ");
		int l=obj.nextInt();
		long areRect=l*b;
		System.out.print("Area of Rectangle is : "+areRect);

	}
}