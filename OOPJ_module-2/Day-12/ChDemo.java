import java.io.*;
class ChDemo{
	public static void main(String [] args)  {
		try{
		m1();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("3");
		
	}
	static void m1() throws IOException{
		System.out.println("1");
		m2();
		System.out.println("1");
	}
	
	static void m2()throws IOException{
		System.out.println("2");
		System.out.println("Enter any character: ");
		int j = System.in.read();//Checked Exception
		System.out.println("Enter char = " +(char)j);
		System.out.println("2");
		
	}
}




