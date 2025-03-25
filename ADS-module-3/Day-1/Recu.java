class Recu{
	static int count=0;
	static void show(){
		//there is no termination conditon thats why it gave exception stack overflow
		int temp=count;
		if(count>20){
			return;
		}
		System.out.println("Hey!!!");
		count++;
		show();//recursive function
		System.out.println(temp);

	}
	public static void main(String[]args){

		show();
	}
}
