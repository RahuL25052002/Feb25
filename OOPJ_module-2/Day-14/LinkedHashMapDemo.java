import java.util.*;
class LinkedHashMapDemo{
/*
 *Key and value 
keys canot be duplicated but value can duplicate
 *
 * in linked hashmap order get preserved 
 */
	public static void main(String[]args){
		Map<Integer,String> m=new LinkedHashMap<Integer,String> ();
		m.put(1,"Rahul");
		m.put(2,"Sai");
		m.put(3,"Mayuri");
		m.put(4,"Mayuri");
		m.put(4,"Mayuri");//duplicate entry not allowed


		m.put(4,"Rohan");//override the value with already presnt key


		m.put(5,"   ");
		m.put(null,null);

		System.out.println(m.get(1));
		System.out.println(m);
		System.out.println(m.get("Rahul"));
		System.out.println(m.get(4));
		m.remove(null);
		//System.out.println(m.get(2,"sai")); not work
		System.out.println(m);
	}

}
