#include <iostream>
#include <vector>
using namespace std;

class Employee {
private:
    int empID;
    string empName;
    double empSalary;

public:
    void setEmpID(int id) { empID = id; }
    void setEmpName(string name) { empName = name; }
    void setEmpSalary(double sal) { empSalary = sal; }

    int getEmpID() { return empID; }
    string getEmpName() { return empName; }
    double getEmpSalary() { return empSalary; }

    double calculateGrossSalary() {
        if (empSalary <= 5000)
            return empSalary + empSalary * 0.10;
        else if (empSalary <= 10000)
            return empSalary + empSalary * 0.15;
        else
            return empSalary + empSalary * 0.20;
    }

    void displayEmployeeDetails() {
        cout << "ID: " << empID << "\nName: " << empName
             << "\nSalary: " << empSalary
             << "\nGross Salary: " << calculateGrossSalary() << endl;
    }
};

int main() {
    vector<Employee> employees;
    int choice;
    
    do {
        cout << "\n1. Add Employee\n2. Display Employee\n3. Update Info\n4. Exit\nEnter choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                Employee e;
                int id;
                string name;
                double sal;
                cout << "Enter ID: "; cin >> id;
                cout << "Enter Name: "; cin.ignore(); getline(cin, name);
                cout << "Enter Salary: "; cin >> sal;
                e.setEmpID(id);
                e.setEmpName(name);
                e.setEmpSalary(sal);
                employees.push_back(e);
                break;
            }
            case 2: {
                for (Employee &e : employees)
                    e.displayEmployeeDetails();
                break;
            }
            case 3: {
                int id;
                cout << "Enter employee ID to update: ";
                cin >> id;
                for (Employee &e : employees) {
                    if (e.getEmpID() == id) {
                        string name;
                        double sal;
                        cout << "Enter new name: "; cin.ignore(); getline(cin, name);
                        cout << "Enter new salary: "; cin >> sal;
                        e.setEmpName(name);
                        e.setEmpSalary(sal);
                        cout << "Updated successfully.\n";
                        break;
                    }
                }
                break;
            }
            case 4:
                cout << "Exiting...\n";
                break;
            default:
                cout << "Invalid option.\n";
        }
    } while (choice != 4);

    return 0;
}

