import java.util.Scanner;

class Bank{
	String bankName;
	double balance=0.0d;

	Bank(){

	}
	

}

class Customer{
	String name;
	String add;
	Long accNo;
	Bank b;
	Customer(String name,long accNo,String add){
		this.name=name;
		this.accNo=accNo;
		this.add=add;
		b=new Bank();
	}
	void deposit(double amount){
		b.balance+=amount;
	}
	void displayDetails(){

		System.out.println("Acoount Holder Name: "+this.name);
		System.out.println("Account No.: "+this.accNo);
		System.out.println("Address : "+this.add);

	}
	void checkBalance(){
		System.out.println("Balance : "+b.balance);
	}
	String withDraw(double amount){
		if(amount>b.balance){
			System.out.println("You have insufficinet balance in your account" );
			return "Insufficient balance: "+b.balance;
		}
		b.balance-=amount;

		return "Remainig balance: "+b.balance;
		
		
	}

}

class BankManagementSystem{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		boolean check=true;
		Customer c1=null;
		do{
			System.out.println();
			System.out.println("____________________________________________");
			System.out.println("Enter 1 for adding customer info: ");
			System.out.println("Enter 2 for deposit amount: ");
			System.out.println("Enter 3 for withdraw amount: ");
			System.out.println("Enter 4 For Check Balance: ");
			System.out.println("Enter 5 Account holder Info : ");
			System.out.println("Enter 6 for Exit");
			System.out.println("____________________________________________");
			System.out.println();

			System.out.print("Enter Number: ");
			int num=obj.nextInt();

			switch(num){

				case 1:
					System.out.print("Enter name: ");
					obj.nextLine();
					String name=obj.nextLine();
					System.out.println("Enter Account No.: ");
					long acc=obj.nextLong();
					System.out.print("Enter address: ");
					obj.nextLine();
					String add=obj.nextLine();
					c1=new Customer(name,acc,add);
					break;
				case 2:
					if(c1==null){
						System.out.println("Enter first User details");
						break;
					}
					System.out.println("Enter amount you want to deposit: ");
					double amount=obj.nextDouble();
					c1.deposit(amount);
					break;
				case 3:
					if(c1==null){
						System.out.println("Enter first user details");
						break;
					}
					System.out.println("Enter Rupees you want to withdraw: ");
					double amo=obj.nextDouble();
					System.out.println(c1.withDraw(amo));
					break;
				case 4:
					if(c1==null){
						System.out.println("Enter first user details");
						break;
					}
					c1.checkBalance();
					break;
				case 5:
					if(c1==null){
						System.out.println("Enter First user details");
						break;
					}
					c1.displayDetails();
					break;
				case 6:
					check=false;
					break;
				default:
					System.out.println("You enter wrong details");
					break;
			}
		}while(check);
	}
}
