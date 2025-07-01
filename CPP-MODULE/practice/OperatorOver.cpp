#include<iostream>
using namespace std;

class Complex{
private:
	int real,imag;
public:
	Complex(){
                real=0;
                imag=0;
        }
	Complex(int r,int i){
		real=r;
		imag=i;
	}

	Complex operator +(Complex c){
		Complex temp;
		temp.real=real+c.real;
		temp.imag=imag+c.imag;
		return temp;
	}


	void print(){

		cout<<real<<" + "<<imag<<"i"<<endl;
	}
};

int main(){
	
	//int x=5;
	//int y=4;
	//int z=x+y;
	//cout<<"z value: "<<z<<endl;
	
	Complex c1(10,20);
	Complex c2(3,-4);
	Complex c(2,2);
	Complex c3;
	c3=c1+c2+c;
	
	c3.print();
	return 0;
}


