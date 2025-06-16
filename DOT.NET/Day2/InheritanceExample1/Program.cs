namespace InheritanceExample1
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            DerivedClass o = new DerivedClass();
            //o.
        }
    }
    public class BaseClass //: Object
    {
        public int A { get; set; }
    }
    public class DerivedClass : BaseClass
    {
        public int B { get; set; }
    }
}

namespace InheritanceExample2
{

    ////default access specifier is internal for members of a namespace

    class Program
    {
        static void Main()
        {
            BaseClass o = new BaseClass();
            //o.

            TestAccessSpecifiers.BaseClass o2 = new TestAccessSpecifiers.BaseClass();
            //o2.
        }
    }

    public class BaseClass
    {
        //public - available everywhere
        //private - same class
        //protected - same class,  derived class
        //internal - same class, same assembly(same project)
        //protected internal - same class,  derived class, same assembly(same project)
        //private protected - same class,  derived class that is in the same assembly
        
        int a;  //default access specifier is private for members of a class

        public int PUBLIC;
        private int PRIVATE;
        protected int PROTECTED;
        internal int INTERNAL;
        protected internal int PROTECTED_INTERNAL;
        private protected int PRIVATE_PROTECTED;
    }
    public class DerivedClass : TestAccessSpecifiers.BaseClass   //:  BaseClass 
    {
        void DoNothing()
        {
            //this.
        }
    }

}
