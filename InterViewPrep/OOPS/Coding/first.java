interface A{
	void show();
}
interface B{
	void show();
}
class C implements A, B{
	public void show(){

		System.out.println("Hello anniruddha!");
	}
	public static void main(String[]rahul){
		System.out.println("In main");
		C obj=new C();
		obj.show();
	}
}
