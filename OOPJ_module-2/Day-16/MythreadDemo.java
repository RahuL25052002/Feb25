class MyThread extends Thread{
	public void run(){

		for(int i=0;i<10;i++){
			System.out.println("In run");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException obj){
			}
		}
	}
}

class MyThreadDemo{
	public static void main(String[]args)throws Exception{
		MyThread obj=new MyThread();
		obj.start();

		MyThread obj2=new MyThread();
		obj2.start();

		for(int i=0;i<10;i++){
			System.out.println("In main");
			Thread.sleep(1000);
		}
	}

}
