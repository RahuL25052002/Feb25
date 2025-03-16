class Flower{
	String name;
	String color;
	boolean hasFragrance;
	Flower(){
		this.name=name;
		this.color=color;
		this.hasFragrance=hasFragrance;
	}
	void display(){

                System.out.println("........"+this.getClass().getName()+" Details.....");
                System.out.println("Flower: "+name);
                System.out.println("color: "+color);
		System.out.print("Has Fragrance: ");
                System.out.println( (hasFragrance)?" Yes":" No");
	}
}

class Rose extends Flower{
	boolean hasThorns;
	Rose(){
		this.hasThorns=hasThorns;
	}
	Rose(String name,String color,boolean hasFragrance,boolean hasThorns){
		this.name=name;
		this.color=color;     
		this.hasFragrance=hasFragrance;
		this.hasThorns=hasThorns;
	}

	void display(){
		super.display();
		System.out.print("Has Thorns: ");
		System.out.println((hasThorns)?" Yes": "No");
	
	}

}

class Lily extends Flower{
	boolean isWaterPlant=true;
	Lily(){
		this.isWaterPlant=isWaterPlant;
	}
	Lily(String name,String color,boolean hasFragrance,boolean isWaterplant){
		this.name=name;
		this.color=color;
		this.hasFragrance=hasFragrance;
		this.isWaterPlant=isWaterPlant;
	}

	  void display(){
                super.display();
		System.out.print("Grows in Water : ");
                System.out.println(isWaterPlant?" Yes": "No");

        }

}

class FlowerDemo{
	public static void main(String[]args){

		Rose r1=new Rose("Rose","Red",true,true);
		r1.display();
		System.out.println();
		Lily l1=new Lily("Lily","White",true,true);
		l1.display();
	}
}

/*
.......Rose Details.....
Flower: Rose
color: Red
Has Fragrance:  Yes
Has Thorns:  Yes

........Lily Details.....
Flower: Lily
color: White
Has Fragrance:  Yes
Grows in Water :  Yes

 */
