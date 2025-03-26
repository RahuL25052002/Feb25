class First{
	static int stackCount=0;
	static int show(int n){
		System.out.println(++stackCount);
		if(n==4){
			//System.out.println(n);
			return n;
		}else{
			//System.out.println(n);
			return 2*show(n+1);
		}
	}
	public static void main(String args[]){
		System.out.println(++stackCount);
		System.out.println(show(2));

	}
}
