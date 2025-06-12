#include<iostream>
using namespace std;
#include<vector>

class Student{
private:
	int id;
	string name;
	int age;
	float marks;
public:
	Student(){
		this->id=0;
		this->name="";
		this->age=0;
		this->marks=0.0f;
	}
	Student( int id,string name,int age,float marks){
		this->id=id;
                this->name=name;
                this->age=age;
                this->marks=marks;
	}
	void display(){
		cout<<"id : "<<this->id<<" Name: "<<this->name<<" age: "<<this->age<<" marks: "<<this->marks<<endl;
	}
	void setId(int id){
		this->id=id;
	}
	int getId(){
		return this->id;
	}
	void setName(string name){
		this->name=name;
	}
	string getName(){
		return this->name;
	}
	void setAge(int age){
		this->age=age;
	}
	int getAge(){
		return this->age;

	}
	void setMarks(float marks){
		this->marks=marks;
	}
	float getMarks(){
		return this->marks;
	}
};

class Admin{
private:
	vector<Student> students;

public:
	Admin(){
		students.push_back(Student(1,"rahul",23,50.0));
	}
	void addStudent(){
		int id,age;
		string name;
		float marks;
		Student s;
		cout<<"Enter id: ";
		cin>>id;
		s.setId(id);
		cout<<"Enter name: ";
		cin>>name;
		s.setName(name);
		cout<<"enter age: ";
		cin>>age;
		s.setAge(age);
		cout<<"enter marks: ";
		cin>>marks;
		s.setMarks(marks);

		students.push_back(s);
		cout<<"Students added: ";

	}
	void getAllStudents(){

		for(Student s:students){
			s.display();
		}
	}


};

int  main(){

	Admin *ptr=new Admin();
	for(int i=1;i<=3;i++){
		ptr->addStudent();
	}

	ptr->getAllStudents();
	return 0;
}
