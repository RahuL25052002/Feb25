class GCD{

	static int GCD(int a,int b){

		if(a>b){
			return (b==0)?a:GCD(b,a%b);
		}else{
			return (a==0)?b:GCD(a,b%a);
		}


	}
		
	public static void main(String[]args){
		
		System.out.println(GCD(18,48));

	}

}
