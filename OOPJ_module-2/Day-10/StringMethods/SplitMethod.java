class SplitMethod{

	public static void main(String[]args){
		
		String str="Rahul Nikale 'PG_DAC' student";
		String regex="[,\\,\\s]";

		String []arr=str.split(regex);

		for(String s: arr){
			System.out.println(s);
		}
	}

}
