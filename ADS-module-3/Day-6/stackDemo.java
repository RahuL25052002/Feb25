class Stack{
	static final int MAX=5;
	static int top=-1;
	static int a[]=new int[MAX];
	static boolean push(int data){
		if(isFull()){
			return false;
		}
		top++;
		a[top]=data;
		return true;
	}
	static int peek(){
		if(isEmpty()){
			return -1;
		}
		int data=a[top];
		return data;
		
	}
	static boolean isEmpty(){
		if(top<0){
			System.out.println("Stack is Empty!!");
			return true;
		}
		return false;
	}
	static boolean isFull(){
		if(top>=(MAX-1)){
			System.out.println("Stack is Full");
			return true;
		}
		return false;
	}
	static int pop(){
		if(isEmpty()){
			return -1;
		}
		int data=a[top];
		top--;
		return data;
	}
}

class StackDemo{
	static Stack s1;
	public static void main(String[]args){
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		System.out.println(s1.peek());
		s1.push(50);
		System.out.println(s1.peek());

		s1.push(60);
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
	}
}
