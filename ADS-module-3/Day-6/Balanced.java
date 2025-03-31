class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}

class Balanced{

	static Node head;
	static Node top;
	Balanced(){
		head=null;
	}
	static void push(int d){
		Node newNode=new Node(d);
		if(head==null){
			head=newNode;
			top=newNode;
		}else{
			top.next=newNode;
			top=newNode;
		}
	}
	static boolean isEmpty(){
		if(head==null){
			return true;
		}
		return false;
	}
	static int pop(){
		if(isEmpty()){
			System.out.println("Stack undeFlow");
			return -1;
		}
		int data=top.data;
		if(top==head){
			head=null;
			return data;
		}
		Node temp=head;
		while(temp.next!=top){
			temp=temp.next;
		}
		temp.next=null;
		top=temp;
		return data;
	}
	static int peek(){
		
		if(isEmpty()){
			System.out.println("Stack underflow");
			return -1;
		}
		return top.data;
	
	}
	static boolean isBal(String s){
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='{'|| s.charAt(i)=='(' || s.charAt(i)=='['){
				push(s.charAt(i));
			}
			if(s.charAt(i)=='}' ){
				int ch=peek();
				if(ch!='{')
					return false;
				pop();
			}else if(s.charAt(i)==']'){
				int ch=peek();
				if(ch!='[')
					return false;
				pop();
				
			}else if(s.charAt(i)==')'){
				int ch=peek();
                                if(ch!='(')
                                        return false;
                                pop();
			}
		}
		return isEmpty();
	}
	public static void main(String[]args){
		String s="{}[](){[)]}";
		boolean ans=isBal(s);
		if(ans){
			System.out.println("Balanced");
		}else{
			System.out.println("Not Balanced");
		}
	}
}

