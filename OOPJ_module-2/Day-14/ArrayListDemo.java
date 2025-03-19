import java.util.*;
class ArrayListDemo{


	public static void main(String[]args){
		//ArrayList a1=new ArrayList(); non type safe

		ArrayList<String> a11=new ArrayList<>();

		a11.add("Rahul");
		a11.add("Sai");
		a11.add("Nikhil");

		System.out.println(a11.get(0));
						
		System.out.println(a11);
		a11.remove(0);//by index
		System.out.println(a11);
		a11.remove("Sai");//by value
		System.out.println(a11);

	}

}
