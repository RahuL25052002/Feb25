import java.util.*;

class Employee{

	int id;
	String name;
	static Map<Integer, String> a;

	Employee(){
	}

	Employee(int id,String  name){
		if(a==null){
			a=new HashMap<>();
			this.id=id;
			this.name=name;
			a.put(id,name);
		}else{
			this.id=id;
			this.name=name;
			a.put(id,name);
		}

	}
	
	public static Map<Integer,String>  getRef(){

		if(a!=null){

			return a;
		}

		return null;
	}
	
	public String toString(){

		return id+" "+name;
	}

}
class MapDemo{

	public static void main(String[]args){
		/*int id=0;
		String name="";
		for(int i=0;i<2;i++){
			id=obj.nextInt();
			obj.nextLine();
			name=obj.nextLine();
			
		}*/

		Employee obj=new Employee();
		Employee e2=new Employee(1,"Rahul");
		Employee e3=new Employee(2,"Tejas");
		Employee e4=new Employee(3,"Mahesh");
		Employee e5=new Employee(4,"Shriram");
		Map<Integer,String> a=obj.getRef();
		a=obj.getRef();
		System.out.println(a);
	}

}
