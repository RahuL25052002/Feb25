import java.util.*;

class GeDemo2<T,U>{
	T x;
	T y;
	GeDemo2(T x){

		this.x=x;
		this.y=y;
	}
	public T show(){
		return this.x+" "+this.y;
	}

	public static void main(String[]args){
		GeDemo1<Integer,String> g=new GeDemo1<>(100,"Rahul");	
		System.out.println(g.show());
	}

}
