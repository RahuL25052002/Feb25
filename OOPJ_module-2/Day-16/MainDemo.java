class MyThread extends Thread{

	public void run(){
		
		for(int i=0;i<5;i++){

			System.out.println(i+" "+Thread.currentThread().getName());
		}

		System.out.println(Thread.currentThread().getName()+" Ended");
	}
}

class MainDemo{
	public static void main(String[]args){
		System.out.println(Thread.currentThread().getName()+" start");
		MyThread t1=new MyThread();
		t1.setName("T1");
		MyThread t2=new MyThread();
                t2.setName("T2");
		MyThread t3=new MyThread();
                t3.setName("T3");
		MyThread t4=new MyThread();
                t4.setName("T4");
		MyThread t5=new MyThread();
                t5.setName("T5");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try{

			t4.join();
			t4.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		t5.start();

		System.out.println(Thread.currentThread().getName()+" Finished");

	}
}
