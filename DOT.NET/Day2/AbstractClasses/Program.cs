namespace AbstractClasses
{
    internal class Program
    {
        static void Main()
        {
            //AbstractClass1 o1 = new AbstractClass1(); //error
            DerivedClass1 o1 = new DerivedClass1();
            o1.Display();


        }
    }

    public abstract class AbstractClass1
    {
        public void Display()
        {
            Console.WriteLine("Display");
        }
    }
    public class DerivedClass1 :AbstractClass1
    {
    }

    public abstract class AbstractClass2
    {
        public abstract void Display();   //pure virtual func
        public abstract void Show();
        public  void M1()
        {
            Console.WriteLine("M1");
        }

    }
    public class DerivedClass2 : AbstractClass2
    {
        public override void Display()
        {
            Console.WriteLine("Di");
        }

        public override void Show()
        {
            Console.WriteLine("Sh");
        }
    }
    public abstract class DerivedClass3 : AbstractClass2
    {
        public override void Display()
        {
            Console.WriteLine("Di");
        }
    }
}


/*
                    Can be Instantiated     Can be a Base class
  
Abstract Class      NO                          YES

Sealed Class        YES                         NO

 */

//TO DO - create a sealed class