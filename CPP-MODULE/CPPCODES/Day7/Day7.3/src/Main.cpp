#include <iostream>
using namespace std;

class Test
{
public:
	int Num1;
	float F2;
};
template <typename T>
class Demo
{
public:
	T Val1;
	T Val2;

	void GetData()
	{
		cout<<"Enter Two Values:"<<endl;
		cin>>this->Val1>>this->Val2;
	}

	void PrintData()
	{
		cout<<"Val1: "<<this->Val1<<" Val2: "<<this->Val2<<endl;
	}
};


int main()
{
	Demo<int> d;		//Class Demo is now Generic or Template class, which can work on any type of data
	d.GetData();
	d.PrintData();

	Demo<string> d1;
	d1.GetData();
	d1.PrintData();

	return 0;
}
