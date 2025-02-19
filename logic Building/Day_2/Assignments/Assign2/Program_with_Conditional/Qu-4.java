/*
Question 4: Discount Calculation
Write a program to calculate the discount based on the total purchase amount. Use the following
criteria:
 If the total purchase is greater than or equal to Rs.1000, apply a 20% discount.
 If the total purchase is between Rs.500 and Rs.999, apply a 10% discount.
 If the total purchase is less than Rs.500, apply a 5% discount.
Additionally, if the user has a membership card, increase the discount by 5%.

*/

import java.util.*;
class Discount{
	public static void main(String[] args){
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter price: ");
		int price=obj.nextInt();
		System.out.print("you have mebershipCard (Yes/No): ");
		String memship=obj.next().toLowerCase();
		int discountPrice=price;
		if(price>=1000){
			if(!memship.equals("yes")){
				discountPrice=price*20/100;
				System.out.println("You get discount of "+discountPrice+" rupees");
			}else{
				discountPrice=price*25/100;
				System.out.println("You get discount of "+discountPrice+" rupees");
	
			}
		}else if(price>1000 && price <=500){
			if(!memship.equals("yes")){
				discountPrice=price*10/100;
				System.out.println("You get discount of "+discountPrice+" rupees");
			}else{
				discountPrice=price*15/100;
				System.out.println("You get discount of "+discountPrice+" rupees");
	
			}
		}else if(price<500 && price>0){
			if(!memship.equals("yes")){
				discountPrice=price*5/100;
				System.out.println("You get discount of "+discountPrice+" rupees");
			}else{
				discountPrice=price*10/100;
				System.out.println("You get discount of "+discountPrice+" rupees");
	
			}
		}else{
			System.out.println("you have usually enter wrong input");
		}	

			
	}		
}