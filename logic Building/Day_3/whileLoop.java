class loops{
	public static void main(String[] args){
		int a=10;
		while(a>=5); //cursor stuck at that point only
		System.out.println("HII");
		
	}		
}

in while(true) code compiler exactly know the value that is true
that code is goes on infinite loop so in compile time gave an error
for memory purpose
means after any line it gave an error 

but in while(a>=5) compiler dont know about its value true/false
thats why it will find out when will be condition get false and it 
goes into infinite loop thats why it cant get an error

is it right na sir?