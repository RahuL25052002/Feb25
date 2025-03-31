import java.util.*;
class PrintLinkedList{
        static Node start;
	static Node pointer;
        static class Node{

                int data;
                Node next;
                Node(int data){

                        this.data=data;
                        next=null;
                }
        }
	static void insert(int data){
		Node newNode=new Node(data);
		if(start==null){
			start=newNode;
			pointer=start;
		}else{
			pointer.next=newNode;
			pointer=newNode;
		}
	
	}
	static void printLL(Node head){
		System.out.print("Start:> ");
		while(head!=null){
			System.out.print(head.data+"=>");
			head=head.next;
		}
		System.out.println("null");
		
	}
	public static void main(String[]args){
		insert(10);
		insert(20);
		insert(30);
		printLL(start);

	}
}
