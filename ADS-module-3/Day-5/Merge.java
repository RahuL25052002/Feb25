import java.util.*;
class LL{
	static Node head1;
	static Node head2;
	static Node head3;
	//static Node top;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}
	}
	static Node insert(Node head,int d){
		Node newNode=new Node(d);
		if(head==null){
			head=newNode;
			//top=newNode;
			return head;
		}else{
			Node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=newNode;
			//top.next=newNode;
			//top=newNode;
		}
		return head;
	}
	static void display(Node head){
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.println("null");
	}
	static Node mergeList(Node head1,Node head2){
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		Node temp1=head1;
		Node temp2=head2;
		Node dummyNode=new Node(-1);
		Node temp3=dummyNode;

		while(temp1!=null || temp2!=null){
			
			if(temp1==null){
				temp3.next=temp2;
				break;
			}else
			if(temp2==null){
				temp3.next=temp1;
				break;
			}else{
				if(temp1.data>temp2.data){
					temp3.next=temp2;
					temp2=temp2.next;
					temp3=temp3.next;
				}else{
					temp3.next=temp1;
					temp1=temp1.next;
					temp3=temp3.next;
				}
				
			}
		
		}
		return dummyNode.next;
	}
}
class Merge{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		LL l1=new LL();
		System.out.println("enter how many Node for LL 1: ");
		int n1=obj.nextInt();
		for(int i=0;i<n1;i++){
			System.out.print("Enter "+(i+1)+" data: ");
			int d=obj.nextInt();
			l1.head1=l1.insert(l1.head1,d);
		}

		System.out.println("enter how many Node for LL 2: ");
                int n2=obj.nextInt();
                for(int i=0;i<n2;i++){
                        System.out.print("Enter "+(i+1)+" data: ");
                        int d=obj.nextInt();
                        l1.head2=l1.insert(l1.head2,d);
                }
		l1.display(l1.head1);
		l1.display(l1.head2);

		l1.head3=l1.mergeList(l1.head1,l1.head2);
		l1.display(l1.head3);
	

	}
}
