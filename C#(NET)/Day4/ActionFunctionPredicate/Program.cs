namespace ActionFunctionPredicate
{
    internal class Program
    {
        public delegate void del1();
        static void Main1()
        {
            //del1 d1 = new del1(Display);  we created the delegates
            //d1();
            Action o1 = Display;
            o1();

            Action<string> o2 = Display;//  means void Display(string)  method signature 
            o2("aaaa");

            Action<string, int> o3 = Display;// means void Display(string,int);
            o3("aaa", 123);
            
        }
        static void Main()
        {
            Func<string> o1 = GetTime;
            Console.WriteLine(o1());

            Func<int, int> o2 = MakeDouble;
            Console.WriteLine(o2(10));

            Func<int, int, int> o3 = Add;
            Console.WriteLine(o3(10, 5));

            Func<int, bool> o4 = IsEven;
            Console.WriteLine(o4(10));

            Predicate<int> o5 = IsEven;
            Console.WriteLine(o5(10));

            Employee emp = new Employee { EmpNo = 1, Basic = 5000 };
            Func<Employee, bool> o6 = IsBasicGreaterThan10000;
            Console.WriteLine(o6(emp));

            Predicate<Employee> o7 = IsBasicGreaterThan10000;
            Console.WriteLine(o7(emp)); ;
        }
        static bool IsBasicGreaterThan10000(Employee emp)
        {
            if (emp.Basic > 10000)
                return true;
            else
                return false;
        }
        static int MakeDouble(int a)
        {
            return a * 2;
        }
        static string GetTime()
        {
            return DateTime.Now.ToLongTimeString();
        }
        static bool IsEven(int a)
        {
            if (a % 2 == 0)
                return true;
            else
                return false;
        }
        static int Add(int a, int b)
        {
            return a + b;
        }
        static void Display()
        {
            Console.WriteLine("Display");
        }
        static void Display(string s)
        {
            Console.WriteLine("Display" + s);
        }
        static void Display(string s, int i)
        {
            Console.WriteLine("Display" + s + i);
        }
    }

    public class Employee
    {
        public int EmpNo { get; set; }
        public decimal Basic { get; set; }

    }
}
