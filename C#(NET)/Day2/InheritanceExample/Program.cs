namespace InheritanceExample1
{
    internal class Program
    {
        static void Main1()
        {
            DerivedClass o1= new DerivedClass();
            
        }
    }
    public class BaseClass
    {
        public int A { get; set; }
    }
    public class DerivedClass : BaseClass
    {
        public int B { get; set; }
    }
}

namespace InheritanceExample
{
    class Program
    {
        static void Main()
        {
            BaseClass o = new BaseClass();
            TestAccesSpecifier.BaseClass o2 = new TestAccesSpecifier.BaseClass();
        }
    }

    public class BaseClass
    {
        int a;//by default access specifier is private
        public int PUBLIC;
        private int PRIVATE;
        protected int PROTECTED;
        internal int INTERNAL;
        protected internal int PROTECTED_INTERNAL;
        private protected int PRIVATE_PROTECTED;
    }
}
