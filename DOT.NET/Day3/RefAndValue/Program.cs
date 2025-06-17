namespace RefAndValue
{
    internal class Program
    {
        static void Main1()
        {
            Class1 o1 = new Class1();
            Class1 o2 = new Class1();
            o1.i = 100;
            o2.i = 200;
            o1 = o2;
            o2.i = 300;
            Console.WriteLine(o1.i);
            Console.WriteLine(o2.i);
        }
        //200,300
        //300,300
        static void Main2()
        {
            int o1, o2;
            o1 = 100;
            o2 = 200;
            o1 = o2;
            o2 = 300;
            Console.WriteLine(o1);
            Console.WriteLine(o2);
            Console.ReadLine();
        }
        static void Main3()
        {
            string o1, o2;
            o1 = "100";
            o2 = "200";
            o1 = o2;
            o2 = "300";
            Console.WriteLine(o1);
            Console.WriteLine(o2);
            Console.ReadLine();
        }
        void DataTypes()
        {
            byte b; //Byte -1
            sbyte sb; //SByte
            short sh; //Int16 -2
            ushort ush; //UInt16
            int i; //System.Int32 - 4
            uint ui; //UInt32
            long l; //Int64 -8
            ulong ul; //UInt64

            float f; //Single - 4
            double d; //Double - 8
            decimal dec; //Decimal - 16

            bool boo; //Boolean
            char ch; //Char - 2

            string s; //String
            object obj; //Object
        }
        void Boxing()
        {
            int i = 100;

            object obj;
            obj = i;//from stack onto heap - Boxing

            int j;
            j = (int)obj; //from heap back to stack - Unboxing

        }
    }
    public class Class1
    {
        public int i;
    }
}
