namespace StaticProp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
        }
    }

    public class Class1
    {
        private static int prop1;
        public static int Prop1
        {
            set
            {
                if (value > 0)
                {
                    prop1 = value;
                }
            }
            get
            {
                return prop1;   
            }
        }
    }
}
