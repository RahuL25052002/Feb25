namespace ContructorsAndDestructors
{
    internal class Program
    {
        static void Main()
        {
            Class1 o1 = new Class1();
            Console.WriteLine(o1.Prop1);
            Console.WriteLine(o1.Prop2);
            Console.WriteLine(o1.Prop3);

            Class1 o2 = new Class1(100, 200, 300);
            Console.WriteLine(o2.Prop1);
            Console.WriteLine(o2.Prop2);
            Console.WriteLine(o2.Prop3);

            o1 = null;
            o2 = null;
        }
    }
    public class Class1
    {
        public int Prop1 { get; set; }
        public int Prop2 { get; set; }
        public int Prop3 { get; set; }

        //public Class1()
        //{
        //    Console.WriteLine("cons called");
        //    Prop1 = 1;
        //    Prop2 = 2;
        //    Prop3 = 3;
        //}
        //public Class1(int Prop1, int Prop2, int Prop3)
        //{
        //    Console.WriteLine("parameterised cons called");
        //    this.Prop1 = Prop1;
        //    this.Prop2 = Prop2;
        //    this.Prop3 = Prop3;
        //}
        public Class1(int Prop1=1, int Prop2=2, int Prop3=3)
        {
            Console.WriteLine(" cons called");
            this.Prop1 = Prop1;
            this.Prop2 = Prop2;
            this.Prop3 = Prop3;
        }

        //dont ever write code in a des
        //~Class1()
        //{
        //    Console.WriteLine("des");
        //}
    }
}
