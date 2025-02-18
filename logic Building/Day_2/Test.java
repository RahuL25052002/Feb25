class Test{
	public static void main(String[]args){
		int a=10;
		int b=10;
		//System.out.println(a&&b);//bad operand
		System.out.println(true && false);//false
		System.out.println(true & false);//false
		System.out.println(a & b);//0
	}
}