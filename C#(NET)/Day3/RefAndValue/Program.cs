namespace RefAndValue
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            int a = 10;
            int b = 20;
            //Init(a, b);//error we have to wite out keyword
            Init(out a,out b);

            swap(ref a,ref b);
            Console.WriteLine(a);
            Console.WriteLine(b);
            int x = 20;
            print(in x);
            print(x);
        }

        static void Init(out int a ,out int b)
        {
            //it descarded the first initialize
            //all the chnages made will be reflect in main function
            //and if we not initialize value in the method it gave an error
            //so we have to initialize in the methhod;

            a = 20;
            b = 30;
        }

        static void swap(ref int a ,ref int b)
        {
            int temp = a;
            a=b; b=temp;
        }

        static void print(in int x)
        {
            //x = 30; error we use here in para so it only the read only .. we cannot change
            Console.WriteLine(x);
        }


    }
}

namespace PassingReferenceTypes
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Class1 obj = new Class1();
            obj.i = 100;
            DoSomething1(obj);
            DoSomething2(obj);
            DoSomething3(ref obj);
            DoSomething4(out obj);
            DoSomething5(in obj);
            DoSomething5(obj);
            Console.WriteLine(obj.i);
        }
        static void DoSomething1(Class1 o2) //o2 = obj
        {
            //pass a reference type
            //changes made in func reflect back in calling code
            o2.i = 200;
        }
        static void DoSomething2(Class1 o2) //o2 = obj
        {
            //making o2 point to something else DOES NOT reflect back in calling code
            o2 = new Class1();
            o2.i = 200;
        }
        static void DoSomething3(ref Class1 o2) //o2 = obj
        {
            //making o2 point to something else reflects back in calling code
            //IF passed as a ref
            o2 = new Class1();
            o2.i = 200;
        }
        static void DoSomething4(out Class1 o2) //o2 = obj
        {
            //making o2 point to something else reflects back in calling code
            //IF passed as a out
            //o2 loses its initial value
            //o2 MUST be initialised
            o2 = new Class1();
            o2.i = 200;
        }
        static void DoSomething5(in Class1 o2) //o2 = obj
        {
            //o2 = new Class1(); //error - o2 is readonly
            //for a reference type readonly means it cant point to something else
            //BUT data can be changed
            o2.i = 200;
        }
    }
    public class Class1
    {
        public int i;
    }
}
