class Parent{
        int x;
        int y;
        void display(){
                System.out.println("X: "+x+" y: "+y);
        }
}
class Child extends Parent{
        Child(int x,int y){
               	this();
                super.display();
        }
	Child(){
		this.x=x;
		this.y=y;
	}
}
class Second{
        public static void main(String[]args){
                Child obj=new Child(67,99);
        }

}
