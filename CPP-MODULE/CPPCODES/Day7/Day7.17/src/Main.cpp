#include <iostream>
#include <vector>
using namespace std;


class Test
{
private:
	int Num1;
public:
	void GetValue()
	{

	}

};
class Test1
{
private:
	int Num2;
public:
	void PrintData()
	{

	}
	friend void Test::GetValue();
};

int main()				//Non Member Function of the class Test
{

	return 0;
}

