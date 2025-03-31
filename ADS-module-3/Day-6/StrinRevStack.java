

class Node{
	int data;
	Node next;
	Node(int d){

		data=d;
		next=null;
	}
}


class StringRevStack{
	static Node head;
	static Node top;
	StringRevStack(){
		head=null;
	}
	static boolean isEmpty(){
		return head==null;
	}
	static void push(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
			top=newNode;
		}else{
			top.next=newNode;
			top=newNode;
		}
	}

	static int pop(){
		if(isEmpty()){
			System.out.println("Stack underflow");
		}else{
			if(head==top){
				int data=head.data;
				head=null;
				return data;
			}
			Node temp=head;
			int data=top.data;
			while(temp.next!=top){
				temp=temp.next;
			}
			temp.next=null;
			top=temp;
			return data;
		}
		return -1;
	}

	static int peek(){

		if(isEmpty()){
			System.out.println("Stack uderflow");
			return -1;
		}
		return top.data;
	}

	static void reverse(StringBuffer s){
		int len=s.length();
		for(int i=0;i<len;i++){
			push(s.charAt(i));
		
		}
		StringBuffer ans=new StringBuffer();
		while(!isEmpty()){

			ans=ans.append((char)pop());
		}
		System.out.println(ans);
	}
			
	public static void main(String[]args){
		StringBuffer s=new StringBuffer("Rahul");
		reverse(s);
	}

}
