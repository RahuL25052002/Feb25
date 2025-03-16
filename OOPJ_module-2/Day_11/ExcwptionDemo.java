class ExceptionDemo{
	void m1(){
		System.out.println("M1");
		m2();
	}
	void m2(){

		System.out.println("M2");
		m1();
	}
	public static void main(String[]args){

		ExceptionDemo obj=new ExceptionDemo();
		//	obj.m1();
		int a=10;
		try{int res=a/0;}catch(Exception e){

			System.out.println("Not divisible by zero");
		}
//		System.out.println(res);
	}

}
