namespace ArraySortingExample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Employee1[] arr = new Employee1[5];
            arr[0] = new Employee1 { EmpNo = 5, Name = "Junaid", Basic = 12335, DeptNo = 10 };
            arr[1] = new Employee1 { EmpNo = 2, Name = "Abhi", Basic = 22335, DeptNo = 20 };
            arr[2] = new Employee1 { EmpNo = 1, Name = "Avni", Basic = 52335, DeptNo = 20 };
            arr[3] = new Employee1 { EmpNo = 4, Name = "Shiti", Basic = 32335, DeptNo = 30 };
            arr[4] = new Employee1 { EmpNo = 3, Name = "Suruchi", Basic = 42335, DeptNo = 40 };

            //Array.Sort<Employee1>(arr );

            // Array.Sort(arr, new Employee1()); //IComparer
            Array.Sort(arr, new Class1()); //IComparer


            foreach (Employee1 item in arr)
            {
                Console.WriteLine(item);
            }
        }
    }

    public class Class1 : IComparer<Employee1>
    {
        public int Compare(Employee1? x, Employee1? y)
        {
            if (x.Basic > y.Basic)
                return -1;
            if (x.Basic == y.Basic)
                return 0;
            return 1;
        }
    }
    public class Employee1
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public short DeptNo { get; set; }
        public override string ToString()
        {
            return $"Empno={EmpNo}, Name={Name}, Basic={Basic}, DeptNo={DeptNo}";
        }
    }
}
