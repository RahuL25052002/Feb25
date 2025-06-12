#include <iostream>
#include <vector>
using namespace std;

class Array
{
public:
	int Size;
	int *ptr;

	Array()
	{
		this->Size=0;
		this->ptr=nullptr;
	}
	Array(int Size)
	{
		this->Size=Size;
		this->ptr=new int[this->Size];
	}

	void AcceptRecord()
	{
		for(int i=0;i<this->Size;i++)
		{
			cout<<"Enter Element: "<<endl;
			cin>>ptr[i];
		}
	}
	void PrintRecord()
	{
		for(int i=0;i<this->Size;i++)
		{
			cout<<ptr[i]<<"\t";
		}
	}
	int Sum()
	{
		int Sum=0;
		for(int i=0;i<this->Size;i++)
		{
			Sum=Sum+ptr[i];
		}
		return Sum;
	}
	~Array()		//Destructor of the Array Class
	{
		delete ptr;
		ptr=nullptr;
	}
	int getSize()
	{
		return this->Size;
	}

};


int main()
{
	Array a1(3);
	a1.AcceptRecord();
	a1.PrintRecord();

	cout<<"The Size of a1 is: "<<a1.getSize();
	cout<<"The Sum of a1 is: "<<a1.Sum();
	return 0;
}

