class Parent{
	int i=100;
	Parent(){
		System.out.println("In parent constructor");
	}
	void show(){

		System.out.println("In parent method");
	}

}

class Child extends Parent{
	int x=2343;
	int i=2737;
	Child(){
		super();
		System.out.println("In child constructor");
	}
	 void show(){
		super.show();
                System.out.println("In child method");
		super.show();
        }
	void display(){

		System.out.println(x);
		System.out.println(i);
		System.out.println(super.i);//calls the parent class instance vcariable
	}
}


class  OverridingDemo{

	public static void main(String[]args){
		Child c1=new Child();
		c1.show();
		c1.display();

	}

}
