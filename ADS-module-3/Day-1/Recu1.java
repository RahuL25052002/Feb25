
class Recu1{
	static int show(int n){
		
		if(n==4){
			return n;
		}else{
			return 2*show(n+1);
		}
	
	}
	public static void main(String[]args){
		System.out.println(show(2));
	}

}
