class Queue{
	static final int SIZE=5;
	static int q[]=new int[SIZE];
	int rear,front;
	Queue(){
		rear=-1;
		front=-1;
	}
	boolean isEmpty(){
		if(front==-1)
			return true;
		return false;
	}
	boolean isFull(){
		if(front!=-1&& rear>=SIZE-1)
			return true;

		return false;
	}	
	void enqueue(int d){
		if(isFull()){
			System.out.println("Queue  is full");
			return;
		}
		q[++rear]=d;
		System.out.println("Inserted: "+q[rear]);
		if(front==-1)
			front++;
		display();
	}
	int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty!");
			return -1;
		}
		int x=q[front];
		if(front>=rear){
			front=-1;
			rear=-1;
		}else
			front++;
		System.out.println("Deleted: "+x);
		return x;
	}
	void display(){
		if(isEmpty()){

			System.out.println("Queue  is  empty");
			return;
		}
		System.out.println("----------------------------------");

		for(int i=0;i<=rear;i++){
			if(i<front)
				 System.out.print("|   |");
			else
				System.out.print("| "+q[i]+" |");
		}
		System.out.println();
		System.out.println("----------------------------------");
	}

}	

class QueueDemo extends Queue{
	public static void main(String[]args){
		Queue q1=new Queue();
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		q1.enqueue(40);
		q1.enqueue(50);
		q1.display();
		q1.dequeue();
		q1.display();
		q1.dequeue();
		q1.dequeue();
		q1.display();
		q1.dequeue();
		q1.display();
		q1.dequeue();
		q1.display();
		q1.enqueue(90);
		q1.display();
	}
}
