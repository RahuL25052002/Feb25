import java.util.*;
class LinkListDemo{
	static Node start;
	static class Node{

		int data;
		Node next;
		Node(int data){

			this.data=data;
			next=null;
		}
	}
	static int countNode(Node head){
		int count=0;
		while(head!=null){
			count++;
			head=head.next;
		}
		return  count;
	}
	static void display(Node head){
			
		Node temp=head;
		System.out.print("Start:->");
		while(temp!=null){
			System.out.print("| "+temp.data+" |=>");
			temp=temp.next;
		}
		System.out.print("null");
		System.out.println();
	
	}
	static void insert(Node newNode){

		if(start==null){
			start=newNode;
		}else{
			Node temp=start;
			while(temp.next!=null){
				temp=temp.next;
			}
			//System.out.println(temp.data);
			temp.next=newNode;
		}
	}

	static  void insAtBegin(int data){
		Node newNode=new Node(data);
		if(start==null){
			start=newNode;
		}else{
			newNode.next=start;
			start=newNode;
		}
	}

	static void insInBetn(int c,int data){

		Node newNode=new Node(data);
		if(start==null){
			start=newNode;
		}else{
			Node temp=start;
			while(temp.next!=null && temp.data!=c){
				temp=temp.next;
			}
			newNode.next=temp.next;
			temp.next=newNode;
		}
	}

	static void deleteNode(int key){
		
		Node  temp=start,prev=null;

		if(temp!=null && temp.data==key){
			start=temp.next;
			return ;
		}

		while(temp!=null){

			if(temp!=null && temp.data==key){
				
				prev.next=temp.next;
				temp.next=null;
			}
			prev=temp;
			temp=temp.next;
		}
		
	}

	static void delAtPos(int pos){
		
		int count=countNode(start);
		if(count<pos|| pos==0){
			return;
		}
		Node temp=start;
		int ch=1;
		if(pos==1 && temp!=null){
			start=temp.next;
			return;
		}
		Node prev=null;
		while(temp!=null){
			if(ch==pos){
	
				prev.next=temp.next;
				temp.next=null;
			}
			ch++;
			prev=temp;
			temp=temp.next;
		}
	}

	static boolean search(Node head,int x){

		while(head!=null){
			if(head.data==x){
				return true;
			}
			head=head.next;
		}
		return false;
	}

	static Node reverseLL(Node head){

		Node prev=null;
		Node next=null;
		while(head!=null){

			next=head.next;
			head.next=prev;
			prev=head;
			head=next;
		}
		return prev;
	}

	public static void main(String[]args){
		LinkListDemo l1=new LinkListDemo();

		Scanner obj=new Scanner(System.in);
		System.out.println("Enter how many elements you want to add: ");
		int num=obj.nextInt();
		int i=0;
		while(num!=0){
			System.out.print("Enter data of "+(i+1)+" Node: ");
			insert(new Node(obj.nextInt()));
			i++;
			num--;
		}
		//insAtBegin(50);
		//insInBetn(10,100);
		//insInBetn(90,200);
		/*l1.start=new Node(1);
		Node sec=new Node(2);
		l1.start.next=sec;
		Node thr=new Node(3);
		sec.next=thr;
		Node four=new Node(4);
		thr.next=four;
		Node fiv=new Node(5);
		four.next=fiv;
		Node six=new Node(6);
		//insert(new Node(7));
		fiv.next=six;*/
		//insert(new Node(7));
		//
		//
		//

		 System.out.println("==============================");                                                                 display(start);                                                     System.out.println("==============================");
		 deleteNode(3);

		System.out.println("==============================");

		 display(start);
		 System.out.println("==============================");

		 delAtPos(1);
		 boolean ans=search(start,5);
		 System.out.println("Present :"+ans);
		 System.out.println("==============================");
		 display(start); 
		 System.out.println("==============================");
			
		 start=reverseLL(start);

		 System.out.println("==============================");
                 display(start);
                 System.out.println("==============================");
	}

}
