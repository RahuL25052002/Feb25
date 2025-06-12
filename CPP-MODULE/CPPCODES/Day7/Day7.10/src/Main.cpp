#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int **ptr=(int**)calloc(4,sizeof(int));		//Here ptr is pointer to array of pointers

	ptr[0]=(int*)calloc(3,sizeof(int));			//Every pointer in pointers array is pointing to array of int
	ptr[1]=(int*)calloc(3,sizeof(int));
	ptr[2]=(int*)calloc(3,sizeof(int));
	ptr[3]=(int*)calloc(3,sizeof(int));

	for(unsigned int i=0;i<4;i++)
	{
		for(unsigned int j=0;j<3;j++)
		{
			cout<<"Enter Element: "<<endl;
			cin>>ptr[i][j];
		}
	}
	for(unsigned int i=0;i<4;i++)
		{
			for(unsigned int j=0;j<3;j++)
			{
				cout<<ptr[i][j]<<"\t";
			}
			cout<<endl;
		}


	for(unsigned int i=0;i<4;i++)
	{
		free(ptr[i]);
	}

	free(ptr);
	ptr=nullptr;

	return 0;
}

