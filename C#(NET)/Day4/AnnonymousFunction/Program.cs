namespace AnnonymousFunction
{
    internal class Program
    {
        static void Main()
        {
            int i = 100;
            Action o1 = delegate
            {
                Console.WriteLine("Annonymous Function!!");
                ++i;
            };
            Console.WriteLine(i);//100
            o1();//here to call the annon function
            Console.WriteLine(i);//101

            Func<int,int,int> o2=delegate(int a,int b)
            {

                return a + b; 
            };
            Console.WriteLine(o2(10,20));

            Employee emp=new Employee(1,1999);

            Predicate<Employee> o3 = delegate (Employee emp)
            {
                return emp.Basic > 10000;
            };

            Console.WriteLine(o3(emp));

            Func<int, int> o4 = delegate (int d)
            {
                return d * 2;
            };
            Console.WriteLine(o4(3000));

            Func<String> o5 = delegate
            {
                return DateTime.Now.ToLongTimeString();
            };
            Console.WriteLine(o5());

            Predicate<int> o6 = delegate (int a)
            {
                return a % 2 == 0;
            };

            Console.WriteLine(o6(12));


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

        public Employee(int EmpNo,decimal Basic) {
            this.EmpNo = EmpNo;
            this.Basic = Basic;
        }

    }
}
