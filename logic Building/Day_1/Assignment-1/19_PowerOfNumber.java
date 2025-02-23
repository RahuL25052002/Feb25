import java.util.*;

class PowerOfNumber{
	public static void main(String[] args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter base number: ");
		int base=obj.nextInt();
		System.out.println("Enter exponent number: ");
		int expo=obj.nextInt();
		long ans=1;
		for(int i=0;i<expo;i++){
			ans=ans*base;
		}
		System.out.println(base+" raised to power "+expo+" is "+ans);


	}
}