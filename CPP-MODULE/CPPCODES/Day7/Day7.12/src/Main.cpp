#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int *ptr=new int;		//Create an integer memory and assign a garbage value to it.
	int *ptr1=new int(123);	//Create an integer memory and assign 123 value to it

	int *ptr2=new int[3];	//Create an array of 3 integers

	cout<<"The Value at ptr: "<<*ptr<<endl;
	cout<<"The Value at ptr1: "<<*ptr1<<endl;

	for(int i=0;i<3;i++)
	{
		cout<<ptr2[i]<<"\t";
	}
	delete ptr,ptr1,ptr2;
	ptr=ptr1=ptr2=nullptr;
	return 0;
}

