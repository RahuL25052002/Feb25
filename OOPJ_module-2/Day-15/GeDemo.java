import java.util.*;

class GeDemo{

	static <T> void display(T ele){

		System.out.println(ele.getClass().getName()+"  "+ele);
	}

	public static void main(String[]args){
		
		display("Rahul");
		display(3774.344);
		display('d');

	}

}
