class MyThread implements Runnable{


	public void run(){

	}
}


class UsingLambda{
	public static void main(String[]args){
		Runnable r1=()->{
			System.out.println("Lambda");
		};
		Thread t1=new Thread(r1);

		t1.start();
	}
}
