namespace ValueType
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
        }
    }

    public struct MyPoint
    {
        public int A
        {
            get ; set;
        }
        public int X;
        private int b;
        public int B
        {
            set
            {
                b=value;
            }
            get
            {
                return b;
            }
        }
        public MyPoint()
        {
            //this.b=0; 
        }

    }
}
