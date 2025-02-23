import java.util.*;

class printNaturalNumber{
	public static void main(String[] args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter a number: ");
		int a=obj.nextInt();
		for(int i=1;i<=a;i++){
			System.out.print(i+" ");
		}

	}
}