class Parent{
        int x;
	Parent(){

	}
	Parent(int k){

		this.x=k;
	}
}
class Child extends Parent{
	int y;
        Child(int p,int w){
		super(w);
		this.x=p;
		this.y=p;
	}
	void display(){
                System.out.println("X: "+x+" y: "+y);
        }
}
class Fourth{
        public static void main(String[]args){
                Child obj=new Child(67,99);
                obj.display();
        }

}
