//Immutable reference

class FinalDemo3{

	public static void main(String[]args){
		
		final StringBuilder sb=new StringBuilder("Rahul");
		/*
		 *In Java, when you declare a variable as final, it means that the reference to the object cannot be changed, but the contents of the object can still be modified if the object itself is mutable
		 */
		sb.append(" Nikale");
		StrinBuilder sb2=new StringBuilder(null);
		sb=sb2;/*
FinalDemo3.java:13: error: cannot assign a value to final variable sb
                sb=sb2;
                ^
2 errors
			  */
		System.out.println(sb);

	}
}
