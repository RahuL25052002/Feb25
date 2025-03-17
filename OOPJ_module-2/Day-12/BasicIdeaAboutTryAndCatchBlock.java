class BasicIdeaAboutTryAndCatchBlock{

	public static void main(String[]args){
	
		try{
			int i=10/0;//here create exception  new ArithmeticException
		}catch(ArithmeticException obj){//in this line it got an refrenc to that object
			/*How it represent actually
			ArithmeticException obj=new ArithmeticException();
			 
			 */
			System.out.println(obj+" "+obj.getMessage());

		}
	
	}
}
