/*
 * store elements in sorted orderimplemented 
 * in BST , AVL trrs , Red and Black rree
 *
 * slighlty slower than hashset: due to sorting
 * sorting O(logn);
 *
 * it cannot store the null value
 *
 *
 */
import java.util.*;
class TreeSetDemo{

	public static void main(String[]args){
		
		Set<Integer> t1=new TreeSet<>();
		t1.add(2);
		t1.add(1);
		t1.add(90);
		t1.add(3);
		t1.add(2);
	//	t1.add(null);//gives error it cannot store null values
		System.out.println(t1);
		
	}

}
