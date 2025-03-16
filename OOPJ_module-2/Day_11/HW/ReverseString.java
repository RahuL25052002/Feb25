
import java.util.Scanner;
class ReverseString{

	public static String reverse4(String str) {
    		if (str.isEmpty())
			return str;
    		return reverse4(str.substring(1)) + str.charAt(0);
	}

	static String reverse3(String str){


		String ans="";
		int i=0;
		int n=str.length()-1;
		while(i<=n){
			//ans=ans.concat(String.valueOf(str.charAt(n)));
			ans=ans+str.charAt(n);
			n--;
		}

		return ans;


	}

	static String reverse2(String str){


		StringBuilder sb=new StringBuilder(str);

		sb.reverse();
		String ans=new String(sb);

		return ans;
	

	}
	
	static  String reverse1(String str){
		int n=str.length();
		int i=0;
		
		StringBuilder sb=new StringBuilder(str);
		StringBuilder ans=new StringBuilder("");
		while(i<n){

			ans=ans.append(sb.charAt(n-1));
			n--;
		}
		String rev=new String(ans);
		return rev;


	}

	public static void main(String[]args){
		
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter a String: ");
		String s=obj.nextLine();

		System.out.println("Before Reverse String s: "+s);

		System.out.println("After  Reverse String s: "+reverse1(s));
		System.out.println("After  Reverse String s: "+reverse2(s));
	
		System.out.println("After  Reverse String s: "+reverse3(s));
		System.out.println("After  Reverse String s: "+reverse4(s));
	}

}
