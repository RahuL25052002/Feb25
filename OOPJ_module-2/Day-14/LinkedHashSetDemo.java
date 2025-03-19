import java.util.*;

class LinkedHashSetDemo{
/*
 *it mainain the insertion order
 slighlty slower than hashset

 use when uniqueness and insertion order followed

 */
	public static void main(String[]args){

		Set<String> s1=new LinkedHashSet<>();
		s1.add("Mango");
		s1.add("Apple");
		s1.add("Apple");
		s1.add("Grapes");
		System.out.println(s1);

	}

}
