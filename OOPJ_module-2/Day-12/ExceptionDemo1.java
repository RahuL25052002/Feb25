import java.io.*;
class ExceptionDemo{

	// it we not write the throws exception it gave an error
	// of IOexception
	public static void main(String[]args)throws Exception{
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);

		System.out.println("Enter the String");
		String s=br.readLine();

		System.out.println(s);
	
	}

}
