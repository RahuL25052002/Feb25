namespace ConstructorInheritance
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //DerivedClass o1 = new DerivedClass();
            DerivedClass o2 = new DerivedClass(123, 456);
            Console.WriteLine(o2.i);
            Console.WriteLine(o2.j);
        }
    }

    public class BaseClass
    {
        public int i;
        public BaseClass()
        {
            Console.WriteLine("base class no param cons");
            i = 10;
        }
        public BaseClass(int i)
        {
            Console.WriteLine("base class int cons");
            this.i = i;
        }
    }
    public class DerivedClass : BaseClass
    {
        public int j;
        public DerivedClass()
        {
            Console.WriteLine("derived class no param cons");
            j = 20;
        }
        public DerivedClass(int i, int j) : base(i)
        {
            Console.WriteLine("derived class int,int cons");
            this.j = j;
        }
    }

}
