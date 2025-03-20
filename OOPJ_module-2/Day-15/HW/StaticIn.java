class OutC{

	void m1(){
		System.out.println("In out m1");

	}
	static class Inner{

		void m1(){
			System.out.println("In inner m1");
		}
	}
}
class StaticIn{
	public static void main(String[]args){
		OutC.Inner obj=new OutC.Inner();
		obj.m1();
	}
}
