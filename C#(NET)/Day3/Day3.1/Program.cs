namespace Day3._1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Console.WriteLine("Hello, World!");
            I1 obj = new Class1();
            obj.B();
        }
    }

    public interface I1 
    {
        public void A();
        public void B();

    }
    public interface I2 : I1
    {
        public void C();
        public void D();
    }

    public class Class1 : I2
    {
        public void A()
        {
            Console.WriteLine("A");
        }
        public void B()
        {
            Console.WriteLine("B");
        }
        public void C()
        {
            Console.WriteLine("C");
        }
        public void D()
        {
            Console.WriteLine("D");
        }
    }
}
