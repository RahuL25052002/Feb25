import java.util.*;

class Test{

	public static void m1(ArrayList l){

		l.add(10);
		l.add(10.5);
		l.add(true);
		/*if we send generic object to non generic boject it 
		 * start behaving like non generic objects and vice versa
		 * */
	}
	
	public static void main(String[]args){
		ArrayList<String> l=new ArrayList<String>();
		l.add("Ram");
		l.add("Nami");
		l.add("Satya");
		System.out.println(l);
		m1(l);

		System.out.println(l);
	}
}
