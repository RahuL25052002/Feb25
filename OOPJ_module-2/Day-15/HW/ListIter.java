import java.util.*;
class ListIter{

	public static void main(String[]args){
		
		List l=new LinkedList();
		l.add("Rahul");
		l.add("Sai");
		l.add("Rohan");
		System.out.println(l);
		ListIterator ltr=l.listIterator();

		while(ltr.hasNext()){
			String s=(String)ltr.next();
			if(s.equals("Rahul")){
				ltr.remove();
			}else if(s.equals("Sai")){
				ltr.add("Chaitanya");//after sai chatanya added
			}else if(s.equals("Rohan")){
				
				ltr.set("Marun");//replacement
			}
		//	System.out.println(ltr.previous());
		
		}
		System.out.println(l);
	}

}
