class Outc{
	void m1(){

		System.out.println("In out m1");
		class InnerC{

			void m1(){
				System.out.println("In inner m1");
			}
		}
		InnerC obj=new InnerC();
		obj.m1();
	}
	void m2(){
		System.out.println("In m2-outer");

	}
	public static void main(String[]args){

		Outc obj=new Outc();
		obj.m1();
		obj.m2();
	}

}

