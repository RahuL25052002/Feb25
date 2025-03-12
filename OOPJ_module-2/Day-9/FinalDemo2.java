
class Parent{
	final void display(){
		System.out.println("In parent final method");
	}
	/*
	 * error: display() in Child cannot override display() in Parent
        void display(){
             ^
  overridden method is final
  final method cannot override
	 */
}

class Child extends Parent{
	
	void display(){
		System.out.println("In child method");
	}

}

class FinalDemo2{
	public static void main(String[]args){

		Parent p=new Parent();
		p.display();

		final Child c;//we can make refernce varibale as final
	}

}
