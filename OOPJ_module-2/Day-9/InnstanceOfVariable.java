class A{

}

class B extends A{


}

class InnstanceOfVariable{
	
	public static void main(String[]args){
		
		A a1=new A();
		B b1=new B();
		B b2=new B();

		System.out.println(b1 instanceof B);// it checks the reference true
		System.out.println(a1 instanceof B);//false
		
	}
}
