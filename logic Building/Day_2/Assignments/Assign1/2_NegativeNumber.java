import java.util.*;
class NegativeNumber{
	public static void main(String[] args){
		Scanner obj =new Scanner(System.in);
		System.out.print("Enter Number: ");
		int a=obj.nextInt();
		if(a<0){
			System.out.println("Number "+a+" is Negative!!");
		}else{
			System.out.println("Number is Not Negative");
		}
	}
}