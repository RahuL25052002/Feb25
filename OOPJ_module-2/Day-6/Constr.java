class Constr{

	Constr(){
		System.out.println("Rahul");
	}
	Constr(int id,String name){

	}
	/*
	Constr(int id,String name){

        }
Constr.java:9: error: constructor Constr(int,String) is already defined in class Constr
        Constr(int id,String name){
        ^
	1 error
	*/

}

class ConstrDemo{

	public static void main(String[]args){
		Constr b=new Constr(1,"Sai");
	}

}
