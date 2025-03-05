class BitExample{
	public static void main(String[]args){
		int num=12;
		/*
		 *in this first
		 convert to 1's complemernt

	msb=0    1 1 0 0

        msb=1    0 0 1 1

		 then it take 2's complemt

		 0 0 1 1
		 +     1
		 ________
	   msb=1 0 1 0 0

	   then it -16+4=12
	   n=12  ans -(n+1)
	   -(12+1)=-13
	   answer is -13

		 */
		System.out.println(~num);


		int a=5;
		int b=3;
		
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(a^b);
		System.out.println(~a&~b);
	}

}
