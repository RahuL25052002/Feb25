class Propagation{
	static void m4(){
		System.out.println("Bhaii ky hal haii...Mere mai to ek exception hai");
		int a=4/0;//Propagation of unchecked exception
	}

	static void m3(){

		System.out.println("Kaisa ho bhaiilog ... are m4 ko bhi kar call");
		m4();

	}
	static void m2(){

		System.out.println("Thik hai baii!!....Ruk mai m3 ko call karta hu");
		m3();
	}
	static void m1(){

		System.out.println("Kya chal raha hai m2");
		m2();
	}
	public static void main(String[]args){
		m1();
	}

}
