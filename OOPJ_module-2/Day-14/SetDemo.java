import java.util.*;

class SetDemo{
	//A set os collection interface that does not duplication
	//interfase
	//duplicates are not allowed
	//Unoredered collection
	//No indexing is followed
	//
/*
 *
 *	HashSet (Most popular) it uses the HashTable for storeage
 *	unoredered collection(No insertion oreder be follow
 *	INsertion/deletion are fast operation also fast search operation TC O(1)
 *	it allows only one null value
 *
 *
 *
 */
	public static void main(String[]args){

		Set<String> s1=new HashSet<>();
		s1.add("Mango");
		s1.add("Apple");
		s1.add("Apple");
		s1.add("Grapes");
		s1.add(null);//it store the null vaalue also
		System.out.println(s1);
		Iterator itr=s1.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
			itr.remove();
		}
		System.out.println(s1);

	}

}
