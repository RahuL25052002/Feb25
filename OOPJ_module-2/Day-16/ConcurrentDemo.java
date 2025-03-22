
class Counter extends Thread{

	int count=0;
	void increment(){
		count++;
	}
}

class ConcurrentDemo{

	public static void main(String[]args)throws Exception{
		Counter c1=new Counter();
		Thread t1=new Thread(() ->{

			for(int i=0;i<=1000;i++){
			// 0 t0 1000 means loop executed 1001 times thats why answer we got 2002
				c1.increment();
			}
		},"T1");

		Thread t2=new Thread(()->{
			for(int i=0;i<=1000;i++){
				c1.increment();
			}

		},"T2" );

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		System.out.println("Count: "+c1.count);

	}

}
