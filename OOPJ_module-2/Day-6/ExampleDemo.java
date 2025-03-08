class Example{

	int num;
	Example(int n){

		this.num=n;
	}
	void display(){
		System.out.println("Number= "+num);
	}
}
class ExampleDemo{

	public static void main(String[]args){
		Example e=new Example(12);
	}

}
