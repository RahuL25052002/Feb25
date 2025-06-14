#include <iostream>
#include <vector>
#include <algorithm>  //we have use for sort 
using namespace std;

class Student {
protected:
    string name;
    int rollNumber;
    float marks;
    char grade;

public:
    Student(string n, int roll, float m) {
        name = n;
        rollNumber = roll;
        marks = m;
        calculateGrade();
    }

    virtual void displayDetails() const {
        cout << "Name: " << name << endl;
        cout << "Roll Number: " << rollNumber << endl;
        cout << "Marks: " << marks << endl;
        cout << "Grade: " << grade << endl;
    }

    string getName() const { return name; }
    float getMarks() const { return marks; }

    virtual ~Student() {}  

protected:
    void calculateGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 75) grade = 'B';
        else if (marks >= 60) grade = 'C';
        else if (marks >= 40) grade = 'D';
        else grade = 'F';
    }
};

class GraduateStudent : public Student {
private:
    string researchTopic;

public:
    GraduateStudent(string n, int roll, float m, string topic)
        : Student(n, roll, m), researchTopic(topic) {}

    void displayDetails() const override {
        Student::displayDetails();
        cout << "Research Topic: " << researchTopic << endl;
    }
};
bool sortByName(Student* a, Student* b) {
    return a->getName() < b->getName();
}

bool sortByMarks(Student* a, Student* b) {
    return a->getMarks() > b->getMarks();  
}

int main() {
    int n;
    cout << "Enter number of graduate students: ";
    cin >> n;

    vector<Student*> students;

    for (int i = 0; i < n; ++i) {
        string name, topic;
        int roll;
        float marks;

        cout << "\nEnter details for Student " << i + 1 << ":\n";
        cin.ignore();
        cout << "Name: ";
        getline(cin, name);
        cout << "Roll Number: ";
        cin >> roll;
        cout << "Marks: ";
        cin >> marks;
        cin.ignore();
        cout << "Research Topic: ";
        getline(cin, topic);

        students.push_back(new GraduateStudent(name, roll, marks, topic));
    }

    int choice;
    cout << "\nHow would you like to sort the students?\n";
    cout << "1. By Name\n2. By Marks\nChoice: ";
    cin >> choice;

    if (choice == 1) {
        sort(students.begin(), students.end(), sortByName);
    } else if (choice == 2) {
        sort(students.begin(), students.end(), sortByMarks);
    }

    cout << "\n--- Sorted Student List ---\n";
    for (Student* s : students) {
        s->displayDetails();
        cout << "--------------------------\n";
    }

    for (Student* s : students) {
        delete s;
    }

    return 0;
}

