//Snippet 3:

 class WhileLoopBreak {
	public static void main(String[] args) {
		int count = 0;
		while (count < 5) {
			System.out.print(count + " ");
			count++;
			if (count == 3) break;
		}
		System.out.println(count);
	}
}
// Guess the output of this while loop.

/*

Dry Run:-
--> 
	int count=0;
	while(count<5) means 0<5 ie. true go in the body
	--->	print count ie. 0  then count++  means count=1;
		check cond count==3 1==3 ie. false
	while(count<5) means 1<5 ie. true go in the body
	--->	print count ie. 1 then count++  means count=2;
		check cond count==3 2==3 ie. false
	while(count<5) means 2<5 ie. true go in the body
	--->	print count ie. 2  then count++  means count=3;
		check cond count==3 3==3 ie. true then it break the loop
		
	and print count ie. 3;
	
	o/p: 0 1 2 3
		

*/					

