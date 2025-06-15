namespace EmployeeProgram
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
        }
    }
    public  class Employee
    {
        String Name;
        int EmpNo;
        decimal Basic;
        private short deptNo;

        public int DeptNo
        {
            set
            {
                if (value > 0)
                {
                    DeptNo = value;
                }
            }
            get
            {
                return DeptNo;
            }
        }
        decimal GetNetSalary()
        {
            return 0;
        }
    }
}
