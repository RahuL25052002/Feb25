
class Room{
	double h,w,b;

	Room(double h,double w,double b){
		this.h=h;
		this.w=w;
		this.b=b;
	}
	double vol(){
		return h*w*b;
	}

	

}

class RoomDemo{

	public static void main(String[]args){
		Room r1=new Room(5.0,6.0,7.0);
		System.out.println(r1.vol());
	}
}
