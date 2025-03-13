class Pr{
	Pr(){
		System.out.println("In Pr constructor");
	}

	Pr(int x){
		System.out.println("In para Constrcuor");
	}
	static{
		 int x=0;
		System.out.println("In static block");
	}
	{
		System.out.println("In instance block 1");
	}
	
	{
		System.out.println("in instance block 2");
	}


	public static void main(String[]args){
		Pr p=new Pr();
		Pr p1=new Pr();
		Pr p2=new Pr(3);
		int a=Integer.parseInt('A');

	}

}
