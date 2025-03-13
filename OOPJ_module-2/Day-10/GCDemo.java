class GCDemo{
	protected void finalize(){
		System.out.println("Finalize method");
	}
	public static void main(String[]args){
		GCDemo gc1=new GCDemo();
		gc1=null;
		Runtime.getRuntime().gc();//Request gc
	}

}
