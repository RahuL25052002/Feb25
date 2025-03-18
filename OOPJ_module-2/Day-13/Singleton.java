/*for database connectivity we use 
 * beacude we need only one connection for any use
 *
 */

class Singleton{
	private static Singleton s1;

	private Singleton(){
		System.out.println("Singleton refernce instance is created");
	}

	public static Singleton getInstance(){
		if(s1==null){

			s1=new Singleton();
		}
		return s1;
	}

	public void show(){

	}

	public static void main(String[]args){
		
		Singleton obj1=Singleton.getInstance();
		Singleton obj2=Singleton.getInstance();

		System.out.println(obj1==obj2);
	}
}
