import java.io.*;
class DataType{
	public static void main(String[]args)throws IOException{

	FileOutputStream fos=new FileOutputStream("data.txt");

	DataOutputStream dos=new DataOutputStream(fos);
	dos.writeBoolean(true);
	dos.writeInt(20);

	FileInputStream fis=new FileInputStream("data.txt");

	DataInputStream dis=new DataInputStream(fis);

	System.out.println(dis.readBoolean());
	System.out.println(dis.readInt());

	System.out.println("data-read");

	}
}


