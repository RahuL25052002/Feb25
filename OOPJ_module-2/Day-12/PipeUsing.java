class PipeUsing{
	public static void main(String[]args){
		System.out.println("Started the programmmmmm");
		try{
			String s1="12";
			String s2="f";
			int a=Integer.parseInt(s1);
			int b=Integer.parseInt(s2);
			System.out.println("Result: "+a/b);
		}catch(ArithmeticException | NullPointerException | NumberFormatException e){
			//e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Im in Pipe ");

		}catch(Exception e){

			System.out.println("Koi bat nahi uper nahi mila tuze koi to mai hu tere liye");
		}finally{
			System.out.println("Releasing the resources");
		}

		System.out.println("Finishing the program");

	}

}
