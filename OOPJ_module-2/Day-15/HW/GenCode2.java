import java.util.*;

class Test{
	//in this example generic only check at compile time
	//and thats why dont get and any error
	public static void main(String[]args){
		ArrayList l=new ArrayList<String>();
		l.add(100);
		l.add(10.5);
		l.add(true);
		System.out.println(l);
	}
}
