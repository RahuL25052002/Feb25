namespace EventHandling
{
    internal class Program
    {
        //static void Main()
        //{
        //    Class1 objClass1 = new Class1();
        //    //linking the event with the event handling function
        //    //if the event objClass1.InvalidP1 occurs , call objClass1_InvalidP1
        //    objClass1.InvalidP1 += objClass1_InvalidP1;
        //    objClass1.P1 = 101;
        //}

        //static void objClass1_InvalidP1()
        //{
        //    Console.WriteLine("event handled here...");
        //}

        static void Main1()
        {
            Class1 obj = new Class1();
            obj.InvalidP1 += Obj_InvalidP1;
            obj.InvalidP1 += Handler2;
            obj.P1 = 999;

            Console.WriteLine();
            obj.InvalidP1 -= Obj_InvalidP1;
            obj.P1 = 200;

            Console.WriteLine();
            obj.InvalidP1 -= Handler2;
            obj.P1 = 200;


        }
        private static void Handler2()
        {
            Console.WriteLine("event handled here ALSO 2 ...");
        }
        private static void Obj_InvalidP1()
        {
            Console.WriteLine("event handled here...");
        }
    }

    //step 1 : create a delegate class having
    //the same signature as the event handling function
    public delegate void InvalidP1EventHandler();

    public class Class1
    {
        //step 2 : declare the event of the delegate type
        //event is a delegate reference
        public event InvalidP1EventHandler InvalidP1;

        private int p1;
        public int P1
        {
            get
            {
                return p1;
            }
            set
            {
                if (value < 100)
                    p1 = value;
                else
                {
                    //step 3 : raise the event using the delegate ref
                    if(InvalidP1 != null)
                        InvalidP1();
                }
            }
        }
    }
}
namespace EventHandlingWithParameters
{
    internal class Program
    {
        static void Main()
        {
            Class1 obj = new Class1();
            obj.InvalidP1 += Obj_InvalidP1;
            obj.P1 = int.Parse(Console.ReadLine()); 

        }

        private static void Obj_InvalidP1(int InvalidValue)
        {
            Console.WriteLine("event raised .." + InvalidValue);
        }
    }

    //step 1 : create a delegate class having
    //the same signature as the event handling function
    public delegate void InvalidP1EventHandler(int InvalidValue);

    public class Class1
    {
        //step 2 : declare the event of the delegate type
        //event is a delegate reference
        public event InvalidP1EventHandler InvalidP1;

        private int p1;
        public int P1
        {
            get
            {
                return p1;
            }
            set
            {
                if (value < 100)
                    p1 = value;
                else
                {
                    //step 3 : raise the event using the delegate ref
                    if (InvalidP1 != null)
                        InvalidP1(value);
                }
            }
        }
    }
}