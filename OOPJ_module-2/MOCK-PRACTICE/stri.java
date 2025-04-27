class stri{
	public static void main(String[]args){
		String s="Rahul";
		String s1=s.concat(" Nikale");

		StringBuffer s2=new StringBuffer("Rahul");
		StringBuffer s3=s2.append(" Nikale");
		System.out.println(s==s1);
		System.out.println(s2==s3);
	}
}
