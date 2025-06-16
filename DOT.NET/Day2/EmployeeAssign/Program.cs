namespace EmployeeAssignment1
{
    internal class Program
    {
        static void Main(string[] args)
        {
        }
    }

    public class Employee
    {

        string name; //-> no blank names should be allowed
        int empNo; //-> must be greater than 0
        decimal basic;// -> must be between some range
        short deptNo;// -> must be > 0
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (!string.IsNullOrEmpty(value))
                    name = value;
                else
                    Console.WriteLine("Invalid Name");
            }
        }
        public int EmpNo
        {
            get { return empNo; }
            set
            {
                if (value > 0)
                    empNo = value;
                else
                    Console.WriteLine("invalid empno");
            }

        }
        public decimal Basic
        {
            get { return basic; }
            set
            {
                if (value < 10000 || value > 100000)
                    Console.WriteLine("Invalid Basic");
                else
                    basic = value;

            }
        }
        public short DeptNo
        {
            get { return deptNo; }
            set
            {
                if (value > 0)
                    deptNo = value;
                else
                    Console.WriteLine("Invalid EmpNo");
            }
        }
        public decimal GetNetSalary()
        {
            return Basic * 2;
        }
        public Employee(int EmpNo=1, string Name="Default", decimal Basic=10000, short DeptNo=1)
        {
            //this.empNo = EmpNo; //variable - no validations - DONT USE THIS
            this.EmpNo = EmpNo; //Property - set - validations are called
            this.Name = Name;
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }
    }
}

