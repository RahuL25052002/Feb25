namespace Lambdas
{
    internal class Program
    {
        static void Main1()
        {
            Func<int, int> o1 = MakeDouble;
            Console.WriteLine(o1(10));

            Func<int, int> o2 = delegate (int a)
            {
                return a * 2;
            };
            Console.WriteLine(o2(10));

            //Func<int, int> o3 = (a) => a * 2;
            Func<int, int> o3 = a => a * 2;

            Predicate<int> o4 = a => a % 2 == 0;  //EvenOrOdd
            Console.WriteLine(o4(10));

            Console.WriteLine(o3(10));
        }
        static void Main()
        {
            Func<string> o1 = () => DateTime.Now.ToLongTimeString();
            Console.WriteLine(o1());

            Func<int, int, int> o2 = (a, b) => a + b;
            Console.WriteLine(o2(10, 5));

            Func<int, bool> o3 = a =>
            {
                if (a % 2 == 0)
                    return true;
                else
                    return false;
            };
            Console.WriteLine(o3(10));

            Func<int, bool> o4 = a => a % 2 == 0;
            Console.WriteLine(o4(10));
            Predicate<int> o5 = a => a % 2 == 0;
            Console.WriteLine(o5(10));

            Predicate<Employee> o6 = emp => emp.Basic > 10000;
            Employee emp = new Employee { EmpNo = 1, Basic = 15000 };
            Console.WriteLine(o6(emp));
        }
        static bool IsBasicGreaterThan10000(Employee emp)
        {
            return emp.Basic > 10000;
            //if (emp.Basic > 10000)
            //    return true;
            //else
            //    return false;
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
            return a % 2 == 0;
            //if (a % 2 == 0)
            //    return true;
            //else
            //    return false;
        }
        static int Add(int a, int b)
        {
            return a + b;
        }
    }
    public class Employee
    {
        public int EmpNo { get; set; }
        public decimal Basic { get; set; }

    }
}