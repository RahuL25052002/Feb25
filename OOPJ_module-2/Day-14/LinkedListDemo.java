import java.util.*;

class LinkedListDemo{


	public static void main(String[]args){
	

		LinkedList<Integer> l1=new LinkedList<Integer>();//upcsting
		l1.add(1);
		l1.add(10);
		l1.add(3939);
		l1.add(6769);
		System.out.println(l1);
		l1.addFirst(200);
		//
		l1.addLast(10);

		System.out.println(l1);
		

	}
}
