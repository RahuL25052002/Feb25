class ParameterFinal{


	int show(int x){
		return x*x;
	}	

	static int display(final int n){
/*		n=n*2;
 *		We cannot change the final paramter value is already constant
 */
		return 5*n;
	}

	/*
	 *Bytecode of this two mwthod:

	  int show(int);
    Code:
       0: iload_1
       1: iload_1
       2: imul
       3: ireturn

  static int display(int);
    Code:
       0: iconst_5 // here value will be constant thats why it cant change
       1: iload_0
       2: imul
       3: ireturn
	 */
	public static void main(String[]args){
		ParameterFinal obj=new ParameterFinal();
		System.out.println(display(3));
		System.out.println(obj.show(55));
	}

}
