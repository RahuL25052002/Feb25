import java.util.*;

class CelciusToFar{
	public static void main(String[] args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter temperature : ");
		int celcius=obj.nextInt();
		float faren=(celcius *9/5)+32;
		System.out.println(celcius+" Celcius is equal to "+faren+" Fahrenheit");
	}
}