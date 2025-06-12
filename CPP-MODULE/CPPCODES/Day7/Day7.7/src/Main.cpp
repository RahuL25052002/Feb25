#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int *ptr=(int *)calloc(1,sizeof(int));
	*ptr=200;
	cout<<"The Value at ptr: "<<*ptr<<endl;

	free(ptr);
	ptr=nullptr;

	return 0;
}

