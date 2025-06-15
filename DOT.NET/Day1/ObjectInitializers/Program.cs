namespace ObjectInitializers
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Class1 o1 = new Class1();
            o1.Prop1 = 10;
            o1.Prop2 = 20;
            o1.Prop3 = 30;

            //object initializer - use it when there is no constructor
            Class1 o2 = new Class1() { Prop1 = 10, Prop2 = 20, Prop3 = 30 };
            Class1 o3 = new Class1{ Prop1 = 10, Prop2 = 20, Prop3 = 30 };

            Console.WriteLine(o1.Prop1);

        }
    }
    public class Class1
    {
        public int Prop1 { get; set; }
        public int Prop2 { get; set; }
        public int Prop3 { get; set; }
    }
}
