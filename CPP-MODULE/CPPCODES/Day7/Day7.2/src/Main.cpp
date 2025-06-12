#include <iostream>
using namespace std;
template <typename T>

/*
void Display(int Num1, int Num2)
{
	cout<<"Num1: "<<Num1<<" Num2: "<<Num2<<endl;
}
*/

void Display(T val1, T val2)		//Function Template
{
	cout<<"Value1: "<<val1<<" Value2: "<<val2<<endl;
}

int main()
{
	Display(100.56f, 200.78f);
	Display("Malkeet", "Singh");
	Display<int>(100, 200);
	return 0;
}
