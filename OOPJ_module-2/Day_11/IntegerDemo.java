class IntegerDemo{


	public static void main(String[]args){
		int a=10;
		Integer i=Integer.valueOf(a);
		Integer j=new Integer("1234");
		System.out.println(i);
		System.out.println(j);

		Integer k=4848;//Allowed


		System.out.println(k);
		Integer l=Integer.valueOf("1001",2);
		/*
		 *valueOf(String, radix);
		 redix means base of the number System
		 *
		 */
		System.out.println(l);

		int m=l;// automatic unboxing hua

		int b=l.intValue();// explicit unboxing
		

		System.out.println(m);
		System.out.println(b);


/*

		int x=2000;
		int z=2000;
	these are the primmitive fdata types thats here chekc the contebt of that varibale

		*/

		Integer x=200;
		Integer z=200;

		System.out.println(x==z);//false
					 //
		//
		Integer p=122;
		Integer q=122;

		System.out.println(p==q);//true
					 //
		int d=235;
		int f=235;

		System.out.println(d==f);//true 
	/*
	 *inthe range pf -128 to 127 are stored in 
	 the intgeer cahche so where only one time created that objectrs another varibale created then only it get the reference of the same intger form above example we got an idea that 
	 *
	 */

		

	}
}
