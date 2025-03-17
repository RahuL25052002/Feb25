
import java.io.*;
class CheckedException{
	static void m2()throws IOException{
		int a=System.in.read();//exception occur it throws
	}
	static void m1()throws IOException{
		m2();//here then exception comes here also we throws exception
	}
	public static void main(String[]args){
		try{//then handle in the main block
			m1();
		}catch(IOException e){
			System.out.println("In main catch block");
		}
	}
}
