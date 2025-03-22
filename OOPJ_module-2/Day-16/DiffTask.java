import java.util.*;
class MyRun implements Runnable{

	public void run(){

        }
	
}
class AddRunnable implements Runnable{

	public void run(){
		System.out.println(Thread.currentThread().getName());
		int sum=0;
		for(int i=0;i<20;i++){
			System.out.println("Thread 1: sum: "+sum);
			sum+=i;
		}
		//System.out.println("Sum:= "+sum);
		System.out.println("Total sum: "+sum+"  "+Thread.currentThread().getName()+ "  Endend");
	}
}

class MultRun implements Runnable{

	public void run(){
		System.out.println(Thread.currentThread().getName());
		int res=1;
		for(int i=1;i<10;i++){
			System.out.println("Thread 2: mult: "+res);
			res*=i;
		}
		System.out.println("Result: "+res);
		System.out.println("Total mult: "+res+"  "+Thread.currentThread().getName()+ "  Endend");
        }
}
class DiffTask{

	public static void main(String[]args){
		Thread t1=new Thread(new AddRunnable(),"T1");
		Thread t2=new Thread(new MultRun(),"T2");
		t1.start();
		t2.start();
		

		//using 
		Thread t3=new Thread(() ->{
			
			
				System.out.println(Thread.currentThread().getName());
				int sum=0;

				for(int i=0;i<=20;i++){
					if(i%2==0){
						System.out.println("Thread 3 : "+i);
						sum+=i;
						System.out.println("Thread 3 : " +sum);
					}
				
				}

				System.out.println("Total sum: "+sum+"  "+Thread.currentThread().getName()+ "  Endend");

			
		},"T3");
		t3.start();

	}

}
