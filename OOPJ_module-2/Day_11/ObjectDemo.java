class ObjectDemo{
	String name;
	int id;

	ObjectDemo(String name, int id){
		this.name=name;
		this.id=id;
	}
	@Override 
	public String toString(){

		return "objectDemo{name}{id}";
	}
	public static void main(String[]args){
		ObjectDemo obj=new ObjectDemo("Rahul",1);// Object class byDefault parent class of every class
		System.out.println(obj.toString());
	}

}
