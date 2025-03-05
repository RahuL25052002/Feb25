class CommandLine{
	public static void main(String[]args){
		/*for(int i=0;i<5;i++){
			System.out.println(args[i]);
		}*/

		String s1=args[0];
		String s2=args[1];


		//wrapper clases
		//
		int i=Integer.parseInt(s1);
		int j=Integer.parseInt(s2);

		System.out.println(i+j);
		


	}
}
