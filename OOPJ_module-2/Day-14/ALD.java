import java.util.*;

class ALD{

	public static void main(String[]args){
		
		ArrayList<String> a1=new ArrayList<>();
		a1.add("Rahul");
		a1.add("Rahul");
		a1.add("Rahul");
		a1.add("Rahul");
		a1.add("Rahul");
		a1.add("Rahul");
		a1.add("Rahul");

		System.out.println();                                         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> 1");


		//print
		for(int i=0;i<a1.size();i++){

			System.out.print(a1.get(i)+" ");
		}
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> 2");

		for(String r: a1){

			System.out.print(r+ " ");
		}

		System.out.println();                                         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> 3");
		Iterator<String> itr=a1.iterator();

		while(itr.hasNext()){
			System.out.print(itr.next()+" ");
		}

	}

}
