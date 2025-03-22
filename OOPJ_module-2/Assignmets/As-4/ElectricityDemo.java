import java.util.Scanner;

class ElectricityBill{
	private String cName;
	private double unitsConsumed;
	private double billAmount;

	ElectricityBill(String n,double uc){

		this.cName=n;
		this.unitsConsumed=uc;
		this.calBillAmount();
	}
	void calBillAmount(){
		if(unitsConsumed<=100 && unitsConsumed>0){

			billAmount=unitsConsumed*5;
		}if(unitsConsumed>100 && unitsConsumed<=300){
			billAmount=unitsConsumed*7;
		}else if(unitsConsumed>300){
			billAmount=unitsConsumed*10;
		}
	}
	void display(){
		System.out.println("Customer Name: "+cName);
		System.out.println("Units consumed: "+unitsConsumed);
		System.out.println("Total bill Amount: "+billAmount);
	}
}

class ElectricityDemo{
	public static void main(String[]args){

		Scanner obj=new Scanner(System.in);
		System.out.println("How many customer are there: ");
		int a=obj.nextInt();

		ElectricityBill[] e=new ElectricityBill[a];

		for(int i=0;i<e.length;i++){
			System.out.print("Enter the Name of Customer  "+(i+1)+" : ");
			obj.nextLine();
			String n=obj.nextLine();
			System.out.print("Enter how many units of customer"+(i+1)+" consume: ");
			int u=obj.nextInt();
			e[i]=new ElectricityBill(n,u);
		}
		
		for(ElectricityBill d: e){
			System.out.println("----------------------------------------");
			d.display();
			System.out.println("----------------------------------------");
		}
/*

		ElectricityBill eb=new ElectricityBill("Rahul",200);
		eb.calBillAmount();
		eb.display();

		*/
	}
}

