class ExceptionDemo{


	public static void main(String[]args){
		try{		
			int a=10;
			
			int res=a/0;//here throew an exception
	/*
		}catch(Exception e){

		}catch(ArithmeticException e){


		}
		
		 error: exception ArithmeticException has already been caught
                }catch(ArithmeticException e){
                 ^
1 error
		*/
		}catch(ArithmeticException e){
			//catch having child to parent nested catch statement if we give parent to child then it give an error
			e.printStackTrace();
			System.out.println("Bhetla bhau tu ithe");	
		}catch(Exception e){	
			System.out.println("Tu tihte nahitar tar ithe  tr nakki bhetel beacuse i'm the bap of exception");

		}
	}

}
