namespace ClassBasic
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");

            Class1 obj=new Class1();
            obj.Display();
        }
    }
    public class Class1
    {

        public void Display()
        {
            System.Console.WriteLine("Display called");
        }
    }

}
