class InsertAtBegin{


	static Node start;
	static Node pointer;
	static class Node{
		int data;
		Node next;

		Node(int d){
			data=d;
			next=null;
		}
	}
	static void printLL(Node head){
		System.out.print("Start:->");
		while(head!=null){
			System.out.print(head.data+"=>");
			head=head.next;
		}
		System.out.println("null");
	}
	static void insertAtbeg(int data){
		Node newNode=new Node(data);
		if(start==null){
			start=newNode;
			pointer=newNode;
		}else{
			newNode.next=start;
			start=newNode;
		}
	}
	public static void main(String[]args){
		insertAtbeg(10);
		insertAtbeg(100);
		insertAtbeg(1000);
		insertAtbeg(10000);
		insertAtbeg(100000);
		insertAtbeg(1000000);
		printLL(start);
		
	}

}
