import java.util.Scanner;

class Complex{
	private double real;
	private double imag;

	Complex(){

		this.real=0;
		this.imag=0;
	}
	Complex(double real){
		this.real=real;
		this.imag=imag;
	}
	Complex(double real,double imag){

		this.real=real;
		this.imag=imag;
	}
	Complex add(Complex other){
		double newreal = this.real + other.real;
		double newimaginary = this.imag + other.imag;
		return new Complex(newreal, newimaginary);
	}

	Complex multiply(Complex other){
		double newreal = (this.real * other.real) - (this.imag * other.imag);
		double newimaginary = (this.real * other.imag) + (this.imag * other.real);
		return new Complex(newreal, newimaginary);
	}

	void display(){
		System.out.println(this.real + " " + (this.imag >= 0 ? "+" : "-") + " " + this.imag + "i");
	}

}


class ComplexDemo{

	public static void main(String[]args){
		Complex num1 = new Complex(1,-2);
		Complex num2 = new Complex(1.2,-2.989);
		Complex sum = num1.add(num2);
		Complex product = num1.multiply(num2);
		sum.display();
		product.display();
	}
}
