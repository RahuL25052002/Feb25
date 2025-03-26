class ReverseString{
	
	static String revS(String rev,String Ori,int n){

		if(n<0){
			return rev;
		}
		rev=rev+Ori.charAt(n);
		return revS(rev,Ori,n-1);
	}
		
	public static void main(String[]args){
		
		String s="Rahul";
		int n=s.length()-1;
		System.out.println(revS("",s,n));
		
	}
}
