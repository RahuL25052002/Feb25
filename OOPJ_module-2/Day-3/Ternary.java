//Syntax variable = exp1<condn>? exp2(True) : exp3(false)
//
//

class Ternary{
	public static void main(String[]args){
		int num=10;
		String result=(num%2==0) ? "Even" : "Odd";
		System.out.println(result);


		int price=1999;
		double res= (price>1000)? (double)price*0.10 : (double)price*0.05;
		System.out.println(res);

	}

}
