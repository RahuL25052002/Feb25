class Engine{

	String type;
	Engine(String type){
		this.type=type;

	}
}

class Car{

	String model;
	Engine e;

	Car(String model, String type){
		this.model=model;
		this.e=new Engine(type);
	}
	void display(){
		System.out.println("Model: "+model);
		System.out.println("Type of Engine: "+e.type);
	}
}


class Composition{

	public static void main(String[]args){
		
		Car c1=new Car("BMW", "16000cc");
		c1.display();

	}
}
