interface Demo{
	int id=3;
	void display();
	static void game(){
		System.out.println("Why so Serios");
	}
}

class SubDemo implements Demo{
	
	public void display(){
		System.out.println("Display");
	}//we have to make this meyhtos punlic if we not make then it give an error
			       //
	

	
}
class InterFaceDemo{
	public static void main(String[]args){
		Demo a1=new SubDemo();
		a1.display();
		Demo.game();
	//	SubDemo.game();
	}
}
