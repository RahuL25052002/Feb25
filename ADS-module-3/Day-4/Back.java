class Back{
//time complexity goes on the n!
//
//o(n!)
//THis is backtracking in retun goes for the prevois combination check 
	static void display(String str,String res){
		if(str.length()<1){
			System.out.println(res);
			return;
		}
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			String ros=str.substring(0,i)+str.substring(i+1);
			display(ros,res+ch);
		}

	}
	public static void main(String[]args){
		String s="ABC";

		display(s,"");
	}

}
