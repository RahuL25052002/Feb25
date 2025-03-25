class ThrowKeyword{

	public static void main(String []args){
		
		try{
			throw new ArithmeticException("Bhaii mai yaha se tuze fek raha hu!!!");
		}catch(ArithmeticException e){
			System.out.println("Exception handled  : "+e.getMessage());
		}finally{
			System.out.println("released the resources");
		}
	}
}
