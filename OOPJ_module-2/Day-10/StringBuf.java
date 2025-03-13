class StringBuf{

	public static void main(String[]args){

		StringBuffer sb=new StringBuffer("Sai");
		sb.append(" Rahul");

		String r="This thing i need to improve";

		StringBuffer sb2=sb;

		sb.append(" jii");
		System.out.println(sb==sb2);
		System.out.println("sb: "+sb);
		System.out.println("sb2: "+sb2);
		/*
		 *output
		 true
		sb: hey LOOO jjjii
		sb2: hey LOOO jjjii
		 */

/*		sb=r;  StringBuf.java:23: error: incompatible types: String cannot be converted to StringBuffer
                sb=r;
                   ^
1 error
			*/
		System.out.println(r);
		System.out.println(sb);
	}
}
