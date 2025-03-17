class ThrowKeyword{

	public static void main(String []args){
		
		try{
			throw new ArithmeticException();
		}catch(ArithmeticException e){
			System.out.println("Exception handled");
		}finally{
			System.out.println("released the resources");
		}
	}
}
