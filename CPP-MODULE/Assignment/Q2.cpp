#include <iostream>
#include <string>
using namespace std;

class BankAccount {
private:
    int accountNumber;
    string accountHolderName;
    double balance;

public:
    void setAccountNumber(int accNo) { accountNumber = accNo; }
    void setAccountHolderName(string name) { accountHolderName = name; }
    void setBalance(double bal) { balance = bal; }

    int getAccountNumber() { return accountNumber; }
    string getAccountHolderName() { return accountHolderName; }
    double getBalance() { return balance; }

    void deposit(double amount) {
        balance += amount;
        cout << "Deposit successful.\n";
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            cout << "Withdrawal successful.\n";
        } else {
            cout << "Insufficient balance.\n";
        }
    }

    void displayAccountDetails() {
        cout << "Account Number: " << accountNumber << "\nName: " << accountHolderName
             << "\nBalance: " << balance << endl;
    }
};

int main() {
    BankAccount acc;
    int choice;
    acc.setAccountNumber(1001);
    acc.setAccountHolderName("John Doe");
    acc.setBalance(1000);

    do {
        cout << "\n1. Deposit\n2. Withdraw\n3. Display Account\n4. Exit\nEnter choice: ";
        cin >> choice;
        switch (choice) {
            case 1: {
                double amt;
                cout << "Enter amount to deposit: ";
                cin >> amt;
                acc.deposit(amt);
                break;
            }
            case 2: {
                double amt;
                cout << "Enter amount to withdraw: ";
                cin >> amt;
                acc.withdraw(amt);
                break;
            }
            case 3:
                acc.displayAccountDetails();
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

