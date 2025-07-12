import java.io.*;
class FileHandling{

	public static void main(String[]args)throws IOException{
		File f=new File("RahulDir");// 1st time when i run 
		System.out.println(f.exists());// then it gave an false beacause no file created
		//f.createNewFile();//it throws IOExceptio
		//
		f.mkdir();
		 System.out.println(f.exists());
		 

	}
}
