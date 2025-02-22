//Snippet 2:
class DecrementingLoop {
	public static void main(String[] args) {
		int total = 0;
		for (int i = 5; i > 0; i--) {
			total += i;
			if (i == 3) continue;
			total -= 1;
		}
		System.out.println(total);
	}
}
// Guess the output of this loop.
/*
Dry run 
----> total=0
	in for lopp
	   int i=5; 5>0 ie. true then it goes to body
		-->total+=i  means total=total+i; total=0+5 
		   now total=5;
		   if(5==3) ie. false 
		   total=total-1 ie total=5-1  
	           now total=4;
	    then i--
		 i=4; 4>0 ie. true then it goes to body
		-->total+=i  means total=total+i; total=4+4; 
		   now total=8;
		   if(4==3) ie. false 
		   total=total-1 ie total=8-1;  
	           now total=7;
	    then i--
		 i=3; 3>0 ie. true then it goes to body
		-->total+=i  means total=total+i; total=7+3;
		   now total=10;
		   if(3==3) ie. true then continue loop 
	    then i--
		 i=2; 2>0 ie. true then it goes to body
		-->total+=i  means total=total+i; total=10+2;
		   now total=12;
		   if(2==3) ie. false 
		   total=total-1 ie total=12-1  
	           now total=11;
	    then i--
		 i=1; 1>0 ie. true then it goes to body
		-->total+=i  means total=total+i; total=11+1; 
		   now total=12;
		   if(1==3) ie. false 
		   total=total-1 ie total=12-1; 
	           now total=11;
	    then i--
		i=0 0>0 ie. false then it terminate the loop
	print SOP line
	total =11


	o/p:- 11

*/
	
	
					