class Parent{
        int x;
        int y;
        void display(){
                System.out.println("X: "+x+" y: "+y);
        }
}
class Child extends Parent{
        Child(int x,int y){
                this.x=x;
                this.y=y;
        }
	void show(){
		super.display();
		System.out.println(x+y);
	}
}
class Third{
        public static void main(String[]args){
                Parent obj=new Child(67,99);
                obj.show();
        }
}
