
class DoubllyLL{
	static Node start;
	static Node pointer;
	static class Node{
		int data;
		Node prev;
		Node next;

		Node(int d){
			data=d;
			prev=null;
			next=null;
		}

	}
	static void insert(int data){
		Node newNode =new Node(data);
		if(start==null){
			start=newNode;
			pointer=newNode;
		}else{
			newNode.prev=pointer;
			pointer.next=newNode;
			pointer=newNode;
		}
	}
	static void insertAtbegin(int data){
		Node newNode=new Node(data);
		if(start==null){
			start=newNode;
			pointer=newNode;
		}else{
			newNode.next=start;
			start.prev=newNode;
			start=newNode;
		}
	}
	static void display(){
		Node temp=start;
		System.out.print("Start:-Null");
		while(temp!=null){
			System.out.print("<-"+temp.data+"->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	static void prevDisplay(){
		Node temp=pointer;
		 System.out.print("Backword:-Null");
                while(temp!=null){
                        System.out.print("<-"+temp.data+"->");
                        temp=temp.prev;
                }
                System.out.println("null"); 
	}
	static void bothDisplay(){
		Node temp=start;
		Node p=temp;
		System.out.println("Forward diretion: ");
		System.out.print("Start:-Null");                        while(temp!=null){                                              System.out.print("<-"+temp.data+"->");
                        p=temp;
			temp=temp.next;
                }
                System.out.println("null");

		System.out.println("Backward direction: ");
		temp=p;
		System.out.print("Null");
                while(temp!=null){
                        System.out.print("<-"+temp.data+"->");
                        temp=temp.prev;
                }
                System.out.println("null");
	}
	
	static void inserAtbetn(int data,int k){
		if(start==null){
			return;
		}
		Node newNode=new Node(data);
		Node temp=start;
		while(temp.next!=null){
			if(temp.next!=null && temp.data==k){
				newNode.next=temp.next;
				temp.next.prev=newNode;
				newNode.prev=temp;
				temp.next=newNode;
			
			}
			temp=temp.next;
		}
		if(temp!=null && temp.data==k){
			temp.next=newNode;
			newNode.prev=temp;
		}

	}

	static void delNode(int k){
		if(start==null){
			System.out.println("Empty LL");
			return;
		}
		if(start.data==k){
			start=start.next;
			return;


		}
		if(pointer.data==k){
			pointer.prev.next=null;
			return;
		}

		Node temp=start;
		while(temp!=null){

			if(temp!=null && temp.data==k){
				temp.next.prev=temp.prev;
				temp.prev.next=temp.next;
				temp.prev=null;
				temp.next=null;
				return;
			}
			temp=temp.next;
		}

		System.out.println("Not present data to delete");

	}
	

}




class DoubllyLLDemo{
	static DoubllyLL l;
	public static void main(String[]ars){
		l.insert(10);
		l.insert(20);
		l.inserAtbetn(1,20);
		l.insert(40);
		//l.delNode(20);
		System.out.println("======================================");
		l.display();
		 System.out.println("======================================");
		l.delNode(20);
		l.delNode(40);
		l.delNode(10);
		l.delNode(20);

		 System.out.println("======================================");
                l.display();                                             System.out.println("======================================");
		 /*
		l.prevDisplay();
		 System.out.println("======================================");
		l.bothDisplay();
		 System.out.println("======================================");*/
	}
}
