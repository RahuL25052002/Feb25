namespace StaticMembers
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Class1 o1 = new Class1() { i=10};
            Class1.sDisplay();
            Class1.Prop2 = 10;
            Class1 o2 = new Class1 { i=20};
            o1.Display();
            //Console.BackgroundColor = ConsoleColor.Red;
            Console.WriteLine(o1.i);
            Console.WriteLine(o2.i);
            Class1.s_i = 12345;
        }
    }
    public class Class1
    {
        public Class1()
        {
            Console.WriteLine("cons called");
        }
        //implicitly private - cant have access specifiers
        //parameterless
        //cannot be overloaded
        static Class1()
        {
            Console.WriteLine("static cons called");
            s_i = 999;
        }
        public int i;
        //common data for the class - single copy
        public static int s_i;

        public void Display()
        {
            Console.WriteLine("Display");
            Console.WriteLine(i);
            Console.WriteLine(s_i);
        }
        //why static method - no reference required to call the method.
        //can be called directly with ClassName.Method()
        public static void sDisplay()
        {
            Console.WriteLine("static Display");
           // Console.WriteLine(i);  //error - object reference is required
           //from a static member, you can only access static members directly
            Console.WriteLine(s_i);
        }
        //why property -> validations
        //why static data -> single copy
        //why static property? - single copy with validations
        private int prop1;
        public int Prop1
        {
            set
            {
                if (value > 100)
                    Console.WriteLine("invalid value");
                else
                    prop1 = value;
            }
            get
            {
                return prop1;
            }
        }

        private static  int prop2;
        public static int Prop2
        {
            set
            {
                if (value > 100)
                    Console.WriteLine("invalid value");
                else
                    prop2 = value;
            }
            get
            {
                return prop2;
            }
        }

    }
}

//why constructor? - to initialize data members
//why static constructor? - to initialize static data members
//when is the static cons called? - when the class is loaded in memory
//when is the class loaded ? - when the class is accessed for the first time
//   - either when the first object is created 
// OR - when a static member is accessed for the first time

//TO DO - create a static class
//can only have static members
//cannot create an object
//cannot be used as a base class