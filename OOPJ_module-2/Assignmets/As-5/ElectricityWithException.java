import java.util.*;

class ElectricityBill{
	private String cName;
	private double unitsConsumed;
	private double billAmount;

	ElectricityBill(String n,double uc){
		if(uc<0){
			throw new IllegalArgumentException("Negative unit not exist");
		}
		this.cName=n;
		this.calBillAmount();
	}
	void calBillAmount(){
		if(unitsConsumed<=100 && unitsConsumed>0){

			billAmount=unitsConsumed*5;
		}if(unitsConsumed>100 && unitsConsumed<=300){
			billAmount=500+(unitsConsumed-100)*7;
		}else if(unitsConsumed>300){
			billAmount=1900+(300-unitsConsumed)*10;
		}
	}
	void display(){
		System.out.println("Customer Name: "+cName);
		System.out.println("Units consumed: "+unitsConsumed);
		System.out.println("Total bill Amount: "+billAmount);
	}
}

class ElectricityWithException{
	public static void main(String[]args){

		Scanner obj=new Scanner(System.in);
		System.out.println("How many customer are there: ");
		int a=obj.nextInt();

		ElectricityBill[] e=new ElectricityBill[a];

		for(int i=0;i<e.length;i++){
			String n;
			int u=0;
		
			System.out.print("Enter the Name of Customer  "+(i+1)+" : ");
			obj.nextLine();
			n=obj.nextLine();
			try{
				System.out.print("Enter how many units of customer"+(i+1)+" consume: ");
				u=obj.nextInt();
			}catch(IllegalArgumentException | InputMismatchException o){
                               
				System.out.println("You entered Wrong inuts!!");
				System.out.println(o.getMessage());
				System.exit(0);
                                                                                                     		             } 
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

