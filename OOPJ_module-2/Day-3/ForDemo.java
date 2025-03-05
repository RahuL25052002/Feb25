class ForDemo{
	public static void main(String[]args){
		char ch='A';
		for(int i=1;i<=26;i++){
			System.out.print(ch++ +" ");
		}


		for(int i=0;i<=5;i++){
                        System.out.println(i);
			if(i!=3)
				continue;
			System.out.println(i);
                }
	}

}
