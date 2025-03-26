class Toh{
	static int count=0;
	static void toh(int n,char s,char intr,char d){
		count++;
		if(n==1){
			System.out.println(count+" Disk from "+s+" to "+d);

		}else{

			toh(n-1,s,d,intr);
			System.out.println(count+" Disk from "+s+" to "+d);
			toh(n-1,intr,s,d);
		}
	}
	public static void main(String[]args){
		
		toh(3,'A','B','C');
		//System.out.println(count);
	}

}

















