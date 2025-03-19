import java.util.*;

class StackDemo{


	public static void main(String[]args){
		
		Stack<Integer> s1=new Stack<>();
		s1.push(1);
		s1.push(2);
		s1.push(3);

		System.out.println(s1);
		System.out.println(s1.pop());//delete the top 
		System.out.println(s1);
		System.out.println(s1.peek());//gives top element 

	}

}
