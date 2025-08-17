import java.util.*;

class VowelOrConsonent{
	
	public static void isAlpha(char c){
		if((c>=65 && c<=90) || (c>=97 && c<=122)){
			System.out.println(c+" is Alphabet!");
		}else{
			System.out.println(c+" is not alphabet!");
		}
	}
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the character: ");
		char c=obj.next().charAt(0);
		isAlpha(c);
	}
}
