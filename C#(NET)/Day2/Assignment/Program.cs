namespace Assignment
{
    internal class Program
    {
        static void Main()
        {
            //Employee o1 = new Employee();
            //Employee o2 = new Employee();
            //Employee o3 = new Employee();
            ////for checking it work or not
            //Console.WriteLine(o1.EmpNo);
            //Console.WriteLine(o2.EmpNo);
            //Console.WriteLine(o3.EmpNo);

            //Console.WriteLine(o3.EmpNo);
            //Console.WriteLine(o2.EmpNo);
            //Console.WriteLine(o1.EmpNo);

            Employee o1 = new Employee("Amol", 12344, 10);
            Employee o2 = new Employee("Amol", 123465);
            Employee o3 = new Employee("Amol");
            Employee o4 = new Employee();

            Console.WriteLine(o1.EmpNo);
            Console.WriteLine(o2.EmpNo);
            Console.WriteLine(o3.EmpNo);
            Console.WriteLine(o4.EmpNo);
            Console.WriteLine(o1.ToString());

        }
    }
    public class Employee
    {

        string name; //-> no blank names should be allowed
        int empNo; //-> must be greater than 0
        decimal basic;// -> must be between some range
        short deptNo;// -> must be > 0
        static int i = 0;
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
                if (value <10000 || value >100000)
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
        public Employee( string Name = "Default", decimal Basic = 10000, short DeptNo = 1)
        {
            //this.empNo = EmpNo; //variable - no validations - DONT USE THIS
            this.EmpNo =++i; //Property - set - validations are called
            this.Name = Name;
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }

        public override string ToString()
        {
            return this.EmpNo+" "+this.Name + " " + this.Basic + " " + this.DeptNo;
        }
    }
}
