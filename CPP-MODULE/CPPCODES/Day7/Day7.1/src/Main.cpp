#include <iostream>
using namespace std;

class Shape		//Abstract Class
{
public:
	float Area;
	virtual void CalculateArea()=0;		//Pure Virtual Function, Abstract Function


	float GetArea()
	{
		return this->Area;
	}
};
class Circle: public Shape
{
public:
	float Radius;
	Circle()
	{
		this->Radius=0.0;
	}
	Circle(float Radius)
	{
		this->Radius=Radius;
	}
	void CalculateArea()
	{
		this->Area=3.14*this->Radius*this->Radius;
	}
};
class Rectangle: public Shape
{
public:
	float Length;
	float Breadth;

	Rectangle()
	{
		this->Length=0.0;
		this->Breadth=0.0;
	}
	Rectangle(float Length, float Breadth)
	{
		this->Length=Length;
		this->Breadth=Breadth;
	}
	void CalculateArea()
	{
		this->Area=this->Length*this->Breadth;
	}
};
int main()
{
	Shape *ptr=new Circle(30.0);		//Object Up-casting
	ptr->CalculateArea();
	cout<<"The Area of Circle is: "<<ptr->GetArea()<<endl;

	ptr=new Rectangle(10,20);
	ptr->CalculateArea();
	cout<<"The Area of Rectangle is: "<<ptr->GetArea()<<endl;
	return 0;
}
int main1()
{
	//Shape s=new Shape();	//NOT OK	//As Shape is Abstract Class so it can not be instansetiated

	Circle *ptr=new Circle(45.67);		//It will call parameterized constructor of class Circle

	ptr->CalculateArea();				//Early Binding

	cout<<"The Area of Circle is: "<<ptr->GetArea()<<endl;

	return 0;
}
