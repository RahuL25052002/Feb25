import java.util.*;

class GeDemo2<T,U>{
	T x;
	T y;
	GeDemo2(T x,T y){

		this.x=x;
		this.y=y;
	}
	public T show(){
		return this.x;
	}

	public static void main(String[]args){
		GeDemo2<Integer,String> g=new GeDemo2<>(100,"Rahul");	
		System.out.println(g.show());
	}

}
