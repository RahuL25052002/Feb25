class StringDemo{
	public static void main(String[]args){
		String s="A";
		String s1=new String("XYZ");
		System.out.println(s);
		System.out.println(s1);
		int  a=10;
		int  b=10;

		System.out.println(a==b);	
		System.out.println(Integer.hashCode(a));
		System.out.println(Integer.hashCode(b));
		s=s.concat(" BCDE");

		System.out.println(s);
		s=s+"rahuL";
		System.out.println(s);
		s.charAt(0)="R";
		System.out.println(s);
	
	}	
}