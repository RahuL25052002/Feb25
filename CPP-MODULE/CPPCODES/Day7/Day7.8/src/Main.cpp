#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int *ptr=(int*)malloc(4*sizeof(int));

	ptr[0]=10;	//ptr[baseAddress+0]	//First Block, 0th index block
	ptr[1]=20;	//ptr[baseAddess+1*sizeofint]	//Second Block, 1st index block
	ptr[2]=30;	//ptr[baseAddress+2*sizeofint]	//Third Block, 2nd index block
	ptr[3]=40;

	for(unsigned int i=0;i<4;i++)
	{
		cout<<ptr[i]<<"\t";
	}
	free(ptr);
	ptr=nullptr;

	return 0;
}

