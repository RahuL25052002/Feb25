namespace ImplicitVariables
{
    internal class Program
    {
        static void Main1()
        {
            int i = 100;
            var j = 100; //implicit variable
                         //used only for local variables
                         //cant be used for class level vars,fn params and return types
            j = 200;
            //j = "aa";  //error

            var k = "aaa";
            //k = 1234;  //error

            Console.WriteLine(j);
            Console.WriteLine(j.GetType());
        }
    }
}

namespace AnonymousTypes
{
    internal class Program
    {
        static void Main1()
        {
            var obj = new { a = 1, b = "aaa", c = true };
            var obj2 = new { a = 2, b = "bbb", c = false};

            Console.WriteLine(obj.a);
            Console.WriteLine(obj.b);
            Console.WriteLine(obj.c);

            Console.WriteLine(obj.GetType());
            Console.WriteLine(obj2.GetType());

        }
    }
}

namespace PartialClasses
{
    //PARTIAL CLASSES
    //partial classes must be in the same assembly
    //partial classes must be in the same namespace
    //partial classes must have the same name
    public partial class Class1
    {
        public int i;
    }
    public partial class Class1
    {
        public int j;
    }
    public class Program
    {
        public static void Main3()
        {
            Class1 o = new Class1();
            //o.i
        }
    }
}

namespace PartialClasses
{
    public partial class Class1
    {
        public int k;
    }
}

namespace PartialMethods
{
    public class MainClass
    {
        public static void Main()
        {
            Class1 o = new Class1();
            Console.WriteLine(o.Check());
            Console.ReadLine();
        }
    }
    //Partial methods can only be defined within a partial class.
    //Partial methods must return void.
    //Partial methods can be static or instance level.
    //Partial methods cannnot have out params
    //Partial methods are always implicitly private.
    public partial class Class1
    {
        private bool isValid = true;
        partial void Validate();
        public bool Check()
        {
            //.....
            Validate();
            return isValid;
        }
    }

    public partial class Class1
    {
        partial void Validate()
        {
            //perform some validation code here
            isValid = false;
        }
    }
}