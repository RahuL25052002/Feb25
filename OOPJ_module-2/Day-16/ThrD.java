
class Sync extends Thread{

	synchronized void m1(){
		System.out.println(Thread.currentThread().getName()+" started");
		try{ Thread.sleep(1000);}catch(Exception e){}
		 System.out.println(Thread.currentThread().getName()+" Finished");
	}

	synchronized void m2(){
                System.out.println(Thread.currentThread().getName()+" started");
                try{ Thread.sleep(1000);}catch(Exception e){}
                 System.out.println(Thread.currentThread().getName()+" Finished");
        }


	 void m3(){
                System.out.println(Thread.currentThread().getName()+" started");
                try{ Thread.sleep(1000);}catch(Exception e){}
                 System.out.println(Thread.currentThread().getName()+" Finished");
        }

	 synchronized static void m4(){
                System.out.println(Thread.currentThread().getName()+" started");
                try{ Thread.sleep(1000);}catch(Exception e){}
                 System.out.println(Thread.currentThread().getName()+" Finished");
        }
	 static void m2(){
                System.out.println(Thread.currentThread().getName()+" started");
                try{ Thread.sleep(1000);}catch(Exception e){}
                 System.out.println(Thread.currentThread().getName()+" Finished");
        }
}

class ThrD{

	public static void main(String[]args)throws Exception{
		
		Sync s1=new Sync();

	}

}
