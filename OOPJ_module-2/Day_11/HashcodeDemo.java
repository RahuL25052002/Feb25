class HashcodeDemo{
		
	public int hashCode(){
		return 12345;
	}

	public static void main(String[]args){
		
		HashcodeDemo obj=new HashcodeDemo();

		System.out.println(obj.hashCode());

	}
}
