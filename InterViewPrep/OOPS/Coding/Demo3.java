class Demo2{

	public static void main(String[] R){
		StringBuffer s1=new StringBuffer("rahul");
		StringBuffer s2=new StringBuffer("rahul");
		System.out.println(s1==s2);
		System.out.println(s1.toString().equals(s2.toString()));
	}
}
