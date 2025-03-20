import java.util.*;

class GenericDemo1{

	T x;
	T display(T x, T y){

		System.out.println(x +" "+y);
		return 0;
	}

	public static void main(String[]args){
		
		GenericDemo1 g=new GenericDemo1();
		g.display(10,20);
		g.display("Rahul","Sai");

	
	}
}
