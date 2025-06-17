
//readonly  property with only get no set
namespace EmployeeAssignment2
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            Employee o1 = new Employee();
            Employee o2 = new Employee();
            Employee o3 = new Employee();

            Console.WriteLine(o1.EmpNo);
            Console.WriteLine(o2.EmpNo);
            Console.WriteLine(o3.EmpNo);
            Console.WriteLine(o3.EmpNo);
            Console.WriteLine(o2.EmpNo);
            Console.WriteLine(o1.EmpNo);

        }
    }

    public class Employee
    {

        string name; //-> no blank names should be allowed
        int empNo; //-> must be greater than 0
        decimal basic;// -> must be between some range
        short deptNo;// -> must be > 0
        static int count;
        public Employee(string Name = "default", decimal Basic = 20000, short DeptNo = 10)
        {
            empNo = ++count;
            //this.name = Name; //variable - validations will not be called
            this.Name = Name;//property set - validations will be called
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (value != "")
                    name = value;
                else
                    Console.WriteLine("Invalid Name");
            }
        }
        public int EmpNo
        {
            get { return empNo; }

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

    }
}


//readonly  property with only get no set
namespace EmployeeAssignment2b
{
    internal class Program
    {
        static void Main2(string[] args)
        {
            Employee o1 = new Employee();
            //o1.EmpNo = 123;


        }
    }

    public class Employee
    {

        string name; //-> no blank names should be allowed
        int empNo; //-> must be greater than 0
        decimal basic;// -> must be between some range
        short deptNo;// -> must be > 0
        static int count;
        public Employee(string Name = "default", decimal Basic = 20000, short DeptNo = 10)
        {
            //empNo = ++count; //variable
            EmpNo = ++count; //property
            //this.name = Name; //variable - validations will not be called
            this.Name = Name;//property set - validations will be called
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (value != "")
                    name = value;
                else
                    Console.WriteLine("Invalid Name");
            }
        }

        //property accessor
        //any one of get/set can have a lesser access than the property
        public int EmpNo
        {
            get { return empNo; }
            private set { empNo = value; }
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

    }
}

//readonly auto  property with only get no set
namespace EmployeeAssignment2c
{
    internal class Program
    {
        static void Main2(string[] args)
        {
            Employee o1 = new Employee();
            //o1.EmpNo = 123;


        }
    }

    public class Employee
    {

        string name; //-> no blank names should be allowed
        decimal basic;// -> must be between some range
        short deptNo;// -> must be > 0
        static int count;
        
        public Employee(string Name = "default", decimal Basic = 20000, short DeptNo = 10)
        {
            //empNo = ++count; //variable
            EmpNo = ++count; //property - set - only available in constructor
            //this.name = Name; //variable - validations will not be called
            this.Name = Name;//property set - validations will be called
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (value != "")
                    name = value;
                else
                    Console.WriteLine("Invalid Name");
            }
        }

        public int EmpNo
        {
            get;
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

    }
}
