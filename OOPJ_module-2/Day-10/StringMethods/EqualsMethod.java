class EqualsMethod{

	public boolean equalsDemo(String str1,String str2){
		
		if(str1.length()!=str2.length()){

			return false;
		}

		for(int i=0;i<str1.length();i++){

			if(str1.charAt(i)!=str2.charAt(i))
				return false;
		}
		return true;

	}

	public static void main(String[]args){
		String s1="Rahul";
		String s2=new String("Rahul");

		String s3="Rahul";
		String s4="Nikale";

		
		System.out.println(s1.equals(s2));
		EqualsMethod e=new EqualsMethod();
		System.out.println(e.equalsDemo(s1,s2));
		System.out.println(s3.equals(s4));
		System.out.println(e.equalsDemo(s3,s4));
	}
}
