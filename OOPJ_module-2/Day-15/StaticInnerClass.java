class OClass{

	static int x=1000;

	static void display(){

		System.out.println("Static M");
	}
	static class IClass{
		static int y=5000;
		static void display1(){
			System.out.println("Inner Static method");
		}
	}
}
class StaticInnerClass{
	
	public static void main(String[]args){
		OClass o1=new OClass();
		System.out.println(o1.x);
		
		OClass.display();
		OClass.IClass.display1();
		OClass.IClass o2=o1.new IClass();

		System.out.println(OClass.IClass.x);
		System.out.println(OClass.IClass.y);


	}

}
