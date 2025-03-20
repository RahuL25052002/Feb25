import java.util.*;

class GenericDemo{

	public static void main(String[]args){
		
		ArrayList a1=new ArrayList();
		a1.add(00);
		a1.add("OOP");
		a1.add(12.22);

		System.out.println(a1);

		ArrayList<Integer> a11=new ArrayList<>();//type safe

		a11.add(10);
		a11.add(23.33);

		//we have to make a gernerlise for Integer string Float
	}
