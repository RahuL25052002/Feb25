#include <iostream>
#include <vector>
using namespace std;

class Test
{
private:
	int Num1;
	int Num2;
	void Show()
	{
		cout<<"Am Private Show Function of Test"<<endl;
	}
public:
friend class MyTest;	//Declaring a whole class as friend, it means all the member function of class MyTest can access private property of the class Test
};
class MyTest
{
public:
	void GetDataofTest()
	{
		Test t;
		t.Num1=100;
		t.Num2=200;
		t.Show();
	}
	void SetDataofTest()
	{

	}
	void SetDataofTest1()
		{

		}
	friend class Test;
};

int main()				//Non Member Function of the class Test
{
	MyTest mt;
	mt.GetDataofTest();
	return 0;
}

