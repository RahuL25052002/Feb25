namespace OverloadingHidingAndOverriding
{
    internal class Program
    {
        static void Main1()
        {
            DerivedClass o = new DerivedClass();
            o.Display1();
            o.Display1("");

            o.Display2();
            o.Display3();
        }
        static void Main()
        {
            BaseClass o;
            o = new BaseClass();
            o.Display2(); //non virtual, early binding, depends on how reference is declared
            o.Display3(); //virtual method, late bound - depends on what object is created

            Console.WriteLine();
            o = new DerivedClass();
            o.Display2();
            o.Display3(); //virtual method, late bound

            Console.WriteLine();
            o = new SubDerivedClass();
            o.Display2();
            o.Display3(); //virtual method, late bound

            Console.WriteLine();
            o = new SubSubDerivedClass();
            o.Display2();
            o.Display3(); 



        }
    }
    public class BaseClass
    {
        public void Display1()
        {
            Console.WriteLine("base display1");
        }
        public void Display2()
        {
            Console.WriteLine("base display2");
        }
        public virtual void Display3()
        {
            Console.WriteLine("base display3");
        }
    }

    public class DerivedClass : BaseClass
    {
        //overload
        public void Display1(string s)
        {
            Console.WriteLine("derived display1" + s);
        }
        //hiding
        public new void Display2()
        {
            Console.WriteLine("derived display2");
        }
        //overriding
        public override void Display3()
        {
            Console.WriteLine("derived display3");
        }
    }
    public class SubDerivedClass : DerivedClass
    {
        //hiding
        public new void Display2()
        {
            Console.WriteLine("Subderived display2");
        }
        //overriding
        public override sealed void Display3()
        {
            Console.WriteLine("subderived display3");
        }
    }

    public class SubSubDerivedClass : SubDerivedClass
    {
      
        public new void Display3()
        {
            Console.WriteLine("subsubderived display3");
        }
    }
}
