class TableByRec{
	static int num=1;
	static int Table(int n){
		if(num>10){
			return 1;
		}
		System.out.println("|  "+n*num+"  |");
		return ++num*Table(n);
	}


	static int Table1(int t,int n){
		if(n>10){
			return 1;
		}
		System.out.println("|  "+t*n+"  |");
		return n*Table1(t,++n);
	}
	public static void main(String[]args){
		Table(2);

		System.out.println("_______________________");
		Table1(2,1);
	}
}
