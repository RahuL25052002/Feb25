namespace StaticMembers
{
    internal class Program
    {
        static void Main()
        {
            //Console.WriteLine("Hello, World!");
            Class1 o1= new Class1();
            o1.display();
            Class1.si = 9000;
            Class1.display2();
            //Class2 o2=new Class2();
            Class2.prop1 = 2;
            Console.WriteLine(Class2.prop1);
        }
    }

    public class Class1
    {
        public Class1()
        {
            Console.WriteLine("cons called");
            i = 999;
        }

        static Class1()
        {
            Console.WriteLine("Static cons called");
            si = 1000;
        }
        public int i;
        public static int si;//common data for the class

        public void display()
        {
            Console.WriteLine("Display");
            Console.WriteLine(i);
            Console.WriteLine(si);
            //in non-static method we can call both static 
            //and non-static memebers
        }

        public static void display2()
        {
            Console.WriteLine("In display 2");
            //Console.WriteLine(i);//error non-static cannot call directly from static context
            //object reference required for non-static members
            Console.WriteLine(si);
        }
        private static int prop1;
        public static int Prop1
        {
            set
            {
                if (value > 100)
                {
                    prop1 = value;
                }
                else
                {
                    Console.WriteLine("Invalid value");
                }
            }
            get
            {
                return prop1;
            }
        }
    }

    public static class Class2
    {
        public static  int prop1 { set; get; }

        //Class2 obj = new Class2();

        static Class2()
        {
            Console.WriteLine("Static class const ");
        }
    }

    //public class subclass : Class2
    //{

    //}
}
