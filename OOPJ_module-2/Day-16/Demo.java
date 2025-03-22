//MulitiThreading start
//
//
class Parent{

}
class Demo extends Parent{

	public static void main(String[]args)throws Exception{

		for(int i=0;i<10;i++){

			System.out.println(i);
			Thread.sleep(2000);
		}
		for(int i=19;i<30;i++){

			System.out.println(i);
		}
	}
}
