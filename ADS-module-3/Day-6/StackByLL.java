

class Node{
	int data;
	Node next;
	Node(int d){

		data=d;
		next=null;
	}
}


class StackByLL{
	static Node head;
	static Node top;
	StackByLL(){
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

	static void pop(){
		if(isEmpty()){
			System.out.println("Stack underflow");
		}else{
			if(head==top){
				head=null;
				return;
			}
			Node temp=head;
			while(temp.next!=top){
				temp=temp.next;
			}
			temp.next=null;
			top=temp;
		}
	}

	static int peek(){

		if(isEmpty()){
			System.out.println("Stack uderflow");
			return -1;
		}
		return top.data;
	}


			
	public static void main(String[]args){
		push(10);
		push(20);
		System.out.println(peek());
		pop();
		System.out.println(peek());
		pop();
		System.out.println(peek());
	}

}
