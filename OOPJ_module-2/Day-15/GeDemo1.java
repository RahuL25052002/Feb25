import java.util.*;

class GeDemo1<T>{
	T x;
	GeDemo1(T x){

		this.x=x;
	}
	public T show(){
		return this.x;
	}

	public static void main(String[]args){
		GeDemo1<Integer> g=new GeDemo1<>(100);	
		System.out.println(g.show());
		GeDemo1<String> g1=new GeDemo1<>("Rahul");
                System.out.println(g1.show());
	}

}
