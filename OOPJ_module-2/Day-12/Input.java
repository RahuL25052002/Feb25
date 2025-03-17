import java.io.*;

class Input{

	public static void main(String[]args)throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		System.out.println("Str1: "+str);

		try{
			br.close();
			String str2=br.readLine();
			System.out.println("Str2: "+str2);
		}catch(IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	

	}
}
