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

	Array(Array &a2)
	{
		this->Size=a2.Size;
		this->ptr=new int[this->Size];	//Deep Copy, A new array of type int is given to calli object

		for(int i=0;i<this->Size;i++)
		{
			this->ptr[i]=a2.ptr[i];
		}
	}

};


int main()
{
	Array a1(3);
	a1.AcceptRecord();		//10,20,30
	a1.PrintRecord();
	Array a2=a1;	//a2.Array(a1) //Default Copy Constructor will be called,
	a2.PrintRecord();
	return 0;
}

