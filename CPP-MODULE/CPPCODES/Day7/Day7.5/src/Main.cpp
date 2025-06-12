#include <iostream>
#include <vector>
using namespace std;

class Student
{
public:
	int RollNo;
	string Name;
	int Age;
	float Fees;

	Student()
	{
		this->RollNo=0;
		this->Name="";
		this->Age=0;
		this->Fees=0.0f;
	}
	Student(int RollNo, string Name, int Age, float Fees)
	{
		this->RollNo=RollNo;
		this->Name=Name;
		this->Age=Age;
		this->Fees=Fees;
	}

	void DisplayStudent()const
	{
		cout<<"Roll No: "<<this->RollNo<<" Name: "<<this->Name<<" Age: "<<this->Age<<" Fees: "<<this->Fees<<endl;
	}
};
class Admin
{
private:
	vector<Student> students;		//Statically created object, Association:Coupling
	//vector<Student> stu=new vector<Student>();	//Dynamically created object
public:
Admin()
{
	students.push_back(Student(101,"Malkeet",34,45678.89f));
	students.push_back(Student(102,"Shubham",24,145678.89f));
	students.push_back(Student(103,"Ravi",25,5678.89f));
	students.push_back(Student(104,"Zeenat",21,9978.89f));
}
void AddStudent();
void DeleteStudent();
void UpdateStudent();
void GetAllStudent();
};
void Admin::AddStudent()
{
	Student s;
	cout<<"Enter Roll No: "<<endl;
	cin>>s.RollNo;
	cout<<"Enter Name: "<<endl;
	cin>>s.Name;
	cout<<"Enter Age: "<<endl;
	cin>>s.Age;
	cout<<"Enter Fees: "<<endl;
	cin>>s.Fees;

	students.push_back(s);
	cout<<"Student Added"<<endl;

}
void Admin::DeleteStudent()
{
	int rno;
	bool flag=false;
	cout<<"Enter the Roll No:"<<endl;
	cin>>rno;

	for(unsigned int i=0;i<students.size();i++)
	{
		if(students[i].RollNo==rno)
		{
			flag=true;
			students.erase(students.begin()+i);
			cout<<"Student Deleted"<<endl;
			break;
		}
	}
	if(flag==false)
	{
		cout<<"Student Not Found"<<endl;
	}

}
void Admin::UpdateStudent()
{
	int rno=0;
	bool flag=false;
	cout<<"Enter Roll No:"<<endl;
	cin>>rno;
	for(unsigned int i=0;i<students.size();i++)
	{

		if(students[i].RollNo==rno)
		{

			cout<<"Enter Name: "<<endl;
			cin>>students[i].Name;
			cout<<"Enter Age: "<<endl;
			cin>>students[i].Age;
			cout<<"Enter Fees: "<<endl;
			cin>>students[i].Fees;
			cout<<"Student Updated"<<endl;
			flag=true;
			break;
		}
	}
	if(flag==false)
	{
		cout<<"Student Not Found"<<endl;
	}

}
void Admin::GetAllStudent()
{
	for(Student s:students)
	{
		s.DisplayStudent();
	}
}
int main()
{
	int choice=0;
	Admin *ptr=new Admin();

	do
	{
		cout<<"-----------------------------Student Admin------------------------------"<<endl;
		cout<<"Press 1 to Add Student"<<endl;
		cout<<"Press 2 to Delete Student"<<endl;
		cout<<"Press 3 to Update Student"<<endl;
		cout<<"Press 4 to View All Student"<<endl;
		cout<<"Press 5 to Exit The Program"<<endl;
		cout<<"------------------------------------------------------------------------"<<endl;
		cout<<"Enter Your Choice: "<<endl;
		cin>>choice;
		switch(choice)
		{
		case 1:
			ptr->AddStudent();
			break;
		case 2:
			ptr->DeleteStudent();
			break;
		case 3:
			ptr->UpdateStudent();
			break;
		case 4:
			ptr->GetAllStudent();
			break;
		case 5:
			cout<<"Exiting the Program"<<endl;
			break;
		default:
			cout<<"Invalid choice"<<endl;
		}
	}while(choice!=5);


	delete ptr;
	ptr=nullptr;
	return 0;
}
