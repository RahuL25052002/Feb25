#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int *ptr=(int *)malloc(4);		//Allocating the memory
	*ptr=100;
	cout<<"The Value at ptr: "<<*ptr<<endl;

	free(ptr);						//De-Allocating the memory

	ptr=nullptr;					//Nullifying the ptr

	return 0;
}
int main1()
{
	int Num1;
	void *ptr=malloc(4);		//Heap Memory is label less memory, thats why it should be pointed out by some pointer variable.

	//*ptr=40;	//NOT OK, becouse malloc return type is void
	//cout<<"Value at *ptr: "<<*ptr<<endl;
	return 0;
}
