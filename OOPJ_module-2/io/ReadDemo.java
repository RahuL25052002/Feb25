import java.io.*;

class ReadDemo{

	public static void main(String[]args)throws IOException{
		FileInputStream fis=new FileInputStream("NewFile.txt");/*ifyou want to give another location fioe then you hav to 
		give location of file */
		int i;
		while((i=fis.read())!=-1){
			System.out.print((char)i);

		}

	}
}
