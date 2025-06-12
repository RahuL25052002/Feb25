#include <iostream>
#include <string>
using namespace std;

class Student {
private:
    string name;
    int rollNumber;
    float marks;
    char grade;

public:
    void setName(string n) { name = n; }
    void setRollNumber(int r) { rollNumber = r; }
    void setMarks(float m) { marks = m; }
    void setGrade(char g) { grade = g; }

    string getName() { return name; }
    int getRollNumber() { return rollNumber; }
    float getMarks() { return marks; }
    char getGrade() { return grade; }

    void calculateGrade() {
        if (marks >= 90)
            grade = 'A';
        else if (marks >= 80)
            grade = 'B';
        else if (marks >= 70)
            grade = 'C';
        else if (marks >= 60)
            grade = 'D';
        else
            grade = 'F';
    }

    void displayInfo() {
        cout << "Name: " << name << "\nRoll No: " << rollNumber
             << "\nMarks: " << marks << "\nGrade: " << grade << endl;
    }
};

int main() {
    Student s;
    int choice;

    do {
        cout << "\n1. Accept Info\n2. Display Info\n3. Calculate Grade\n4. Exit\nEnter choice: ";
        cin >> choice;
        switch (choice) {
            case 1: {
                string name;
                int roll;
                float marks;
                cout << "Enter name: ";
                cin.ignore(); getline(cin, name);
                cout << "Enter roll number: ";
                cin >> roll;
                cout << "Enter marks: ";
                cin >> marks;
                s.setName(name);
                s.setRollNumber(roll);
                s.setMarks(marks);
                break;
            }
            case 2:
                s.displayInfo();
                break;
            case 3:
                s.calculateGrade();
                cout << "Grade calculated successfully.\n";
                break;
            case 4:
                cout << "Exiting...\n";
                break;
            default:
                cout << "Invalid choice\n";
        }
    } while (choice != 4);

    return 0;
}

