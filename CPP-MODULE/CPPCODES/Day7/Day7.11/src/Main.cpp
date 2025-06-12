#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int **ptr=(int**)malloc(3*sizeof(int));		//Here, ptr is a pointer variable which pointer to an array of pointers

	for(int i=0;i<3;i++)
	{
		ptr[i]=(int*)malloc(4*sizeof(int));
	}

	for(int i=0;i<3;i++)
	{
		for(int j=0;j<4;j++)
		{
			cout<<"Enter element: "<<endl;
			cin>>ptr[i][j];
		}
	}
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<4;j++)
		{
			cout<<ptr[i][j]<<"\t";
		}
		cout<<endl;
	}

	for(int i=0;i<3;i++)
	{
		free(ptr[i]);
		ptr[i]=nullptr;
	}

	free(ptr);
	ptr=nullptr;
	return 0;
}

int main1()
{
	int *ptr=(int*)malloc(3*sizeof(int));

	ptr[0]=100;
	ptr[1]=200;
	ptr[2]=300;
	for(int i=0;i<3;i++)
	{
		cout<<ptr[i]<<"\t";
	}


	free(ptr);
	ptr=nullptr;
	return 0;
}

