import java.util.*;
class BMICalculator{
	private double height;
	private double weight;
	BMICalculator(){
		this.height=0;
		this.weight=0;
	}
	BMICalculator(double h,double w){
		this.height=h;
		this.weight=w;
	}
	void setBMI(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter height i m: ");
		double h=sc.nextDouble();
		System.out.print("Enter weight in kg: ");
		double w=sc.nextDouble();
		this.height=h;
		this.weight=w;
	}

	double[] getVal(){
		return new double[]{height,weight};
	}
	double calBMI(){
		double bmi=weight/(height*height);
		return bmi;
	}
	void display(double bmi){

		System.out.println("BMI: "+bmi);
	}
}

class BMIDemo{

	public static void main(String[]args){
		int i=1;
		while(i<5){
		BMICalculator b=new BMICalculator();
		b.setBMI();
		double bmi=b.calBMI();
		double[]arr=b.getVal();
		System.out.println("Height: "+arr[0] +" m    Weight: "+arr[1]+" kg");
		b.display(bmi);
		i++;
		}
		
	}
}
