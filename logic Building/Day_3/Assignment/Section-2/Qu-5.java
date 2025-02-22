//Snippet 5:
class ConditionalLoopOutput {
	public static void main(String[] args) {
		int num = 1;
		for (int i = 1; i <= 4; i++) {
			if (i % 2 == 0) {
			num += i;
			} else {
				num -= i;
			}
		}
		System.out.println(num);
	}
}
// Guess the output of this loop.

/* 

Dry Run:=

	num=1;
	for loop 
	  int i=1  i<=4; means 1<=4 ie. true then go in body
	   --> check cond 1%2==0 ie. false goes to else block
			in else num=num-i ie. num=1-1 ie. num=0;
		then i++;
	     i=2  i<=4; means 2<=4 ie. true then go in body
	   --> check cond 2%2==0 ie. true 
			num=num+i; num =0+2; ie. num=2;
		then i++;
             i=3  i<=4; means 3<=4 ie. true then go in body
	   --> check cond 3%2==0 ie. false goes to else block
			in else num=num-i ie. num=2-1 ie. num=1;
		then i++;
	     i=4  i<=4; means 4<=4 ie. true then go in body
	   --> check cond 4%2==0 ie. true 
			num=num+i; num =1+2; ie. num=3;
		then i++; 
	     i=5 i<=4 5<=4 ie. false ...
			then terminate loop
		
		print(num) ie. 3

	o/p:= 3

*/
										
						