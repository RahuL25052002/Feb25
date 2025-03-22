import java.util.Scanner;
class Box{
	double h;
	double w;
	double b;
	static int count=0;

	Box(double h, double w,double b){
		this.h=h;
		this.w=w;
		this.b=b;
	}

	public void getVolume(){
		++count;
		double vol=h*w*b;
		System.out.println("Volume of Box "+count+ ": "+vol);
	}
	public void getArea(){
		double sArea=2*b*w+2*b*h+2*w*h;
		System.out.println("Surface area of Box "+count+": "+sArea);
	}
}

class BoxDemo{
	public static void main(String[]args){
		Box[] b1=new Box[2];
		Scanner obj=new Scanner(System.in);	
		
		for(int i=0;i<b1.length;i++){

			System.out.println("Enter box "+(i+1)+" details: ");
			double h=obj.nextDouble();
			double w=obj.nextDouble();
			double b=obj.nextDouble();
			b1[i]=new Box(h,w,b);
		}
						
		for(int i=0;i<b1.length;i++){
			b1[i].getVolume();
			b1[i].getArea();
		}
	}
}
