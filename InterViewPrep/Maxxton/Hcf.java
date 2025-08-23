class Hcf{

	public static int hcf(int a,int b){
		while(b!=0){
			int temp=b;
			b=a%b;
			a=temp;
		}
		return a;
	}
	public static void main(String[]args){
		int num1=56,num2=98;

		System.out.println(hcf(num1,num2));
	}

}
