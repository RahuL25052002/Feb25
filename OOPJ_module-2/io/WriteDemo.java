import java.io.*;

class WriteDemo{

	public static void main(String[]args)throws IOException{



		FileInputStream fis=new FileInputStream("NewFile.txt");/*ifyou want to give another location fioe then you hav to 
		give location of file */
	
		                                                                       
		FileOutputStream fos=new FileOutputStream("writememo.txt");
		int i;
		while((i=fis.read())!=-1){
			fos.write(i);

		}

	}
}
