#include <iostream>
#include <vector>
using namespace std;

class Test
{
private:
	int Num1;
	int Num2;
private:
	void PrintData()
	{
		cout<<"Num1: "<<this->Num1<<" Num2: "<<this->Num2<<endl;
	}
	friend void GetData();
};

void GetData()			//Non Member Function of the class Test
{
	Test t;
	t.Num1=100;
	t.Num2=200;
	t.PrintData();
}
int main()				//Non Member Function of the class Test
{
	Test t;
	//t.Num1=100; //NOT OK		//main is not member function of the class thats why its can't access private data memebers
	//t.Num2=200;
	//t.PrintData()

	GetData();
	return 0;
}

