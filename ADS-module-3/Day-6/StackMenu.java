import java.util.*;
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
	static void printStack(){
	
		for(int i=top;i>=0;i--){
			System.out.println("| "+a[i]+" |");
		}
	}
}

class StackMenu{
	static Stack s1;
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		do{
			System.out.println("===============================================");
			System.out.println("Enter 1 for push: ");
			System.out.println("Enter 2 for pop: ");
			System.out.println("Enter 3 for peek: ");
			System.out.println("Enter 4 for isEmpty: ");
			System.out.println("Enter 5 for print stack: ");
			System.out.println("Enter 6 for exit!!!");
			System.out.println("===============================================");
			System.out.print("Enter your choice: ");
			int num=0;
			try{
				num=obj.nextInt();
			}catch(InputMismatchException e){
				System.out.println(e);
				System.exit(0);
			}

			switch(num){
				case 1:
					System.out.print("Enter data to push: ");
					int data=obj.nextInt();
					s1.push(data);
					s1.printStack();
					break;
				case 2:
					int data1=s1.pop();
					if(data1==-1){
						System.out.println("Stack Underflow");
					}else
						System.out.println("Deleted data: "+data1);
					s1.printStack();
                                        break;
				case 3:
					int data2=s1.peek();
                                        if(data2==-1){
                                                System.out.println("Stack Underflow");                                                                                                              }else
						System.out.println("Top element: "+data2);
                                        break;
				case 4:
					boolean ans=s1.isEmpty();
					if(ans)
						System.out.println("Stack Underflow");
					else
						System.out.println("Not empty");
                                        break;
				case 5:
					 s1.printStack();
					 break;
				case 6:
					System.exit(0);
                                        break;
				default:
					System.out.println("Choice number is not present");
					break;

			}
		}while(true);


	}
}
