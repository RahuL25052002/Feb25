using System.ComponentModel.DataAnnotations;

namespace InheritanceAssignment
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
        static void Main(string[] args)
        {
            //Employee o1 = new Employee();
            //o1.EmpNo = 123;

            Manager o1 = new Manager("Rahul",12345,11,"Manager");
            o1.Display();

            o1.Name = "Akash";
            Console.WriteLine(o1.GetNetSalary());
            o1.Display();
            GeneralManager o2= new GeneralManager("Mahesh", 33222, 2, "General-Manager","xyz");
            Console.WriteLine(o2.GetNetSalary());
            o2.Display();


            
            Employee o3 = new CEO("Sai",222222,1);
            Console.WriteLine(o3.GetNetSalary());
            o3.Display();

            //
            o3.Display();
            o2.Display();
            o1.Display();
        }
    }

    public abstract class Employee
    {

        string name; //-> no blank names should be allowed
        //abstract decimal basic;// -> must be between some range

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

        public Employee(string Name = "default", short DeptNo = 10)
        {
            //empNo = ++count; //variable
            EmpNo = ++count; //property - set - only available in constructor
            //this.name = Name; //variable - validations will not be called
            this.Name = Name;//property set - validations will be called
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
        public abstract decimal Basic{ get; set; }
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
        public abstract decimal GetNetSalary();

        public abstract void Display();
    }

    public class Manager : Employee
    {

        
        public string Designation {  get; set; }
        private decimal basic;
        public override decimal Basic
        {
            get
            {
                return basic;
            }
            set
            {
                if(value <1000 || value > 1000000)
                {
                    Console.WriteLine("Not valid");
                }else
                    basic = value;
            }
        }

        public override decimal GetNetSalary()
        {
            return Basic * 4;
        }
        public Manager(string Name = "default", decimal Basic = 20000, short DeptNo = 10, string Designation="manager") : base(Name, DeptNo)
        {
            this.Designation = Designation;
            this.Basic = Basic;
        }
        public override void Display()
        {
            Console.WriteLine(EmpNo + " " + Name+" "+Basic+" "+DeptNo+" "+Designation);
        }
    }

    public class GeneralManager : Manager
    {
        
        public string Perks { get; set; }
        public GeneralManager(string Name = "default", decimal Basic = 20000, short DeptNo = 10, string Designation = "manager",string perks="ab"):base(Name,Basic, DeptNo,Designation) {
            this.Perks = perks;
        }
        public override decimal GetNetSalary()
        {
            return Basic *5;
        }

        public override void Display()
        {
            Console.WriteLine(EmpNo + " " + Name + " " + Basic + " " + DeptNo + " " + Designation+" "+Perks);
        }



    }
    public class CEO : Employee
    {
        private decimal basic;
        public override decimal Basic {
            get
            {
                return basic;
            }
            set
            {

            }
        }

        public CEO(string Name = "default", decimal Basic = 20000, short DeptNo = 10):base(Name,  DeptNo) {

            this.basic=Basic;  
        }

        public override sealed decimal GetNetSalary()
        {
            return Basic * 5;
        }

        public override void Display()
        {
            Console.WriteLine(EmpNo+" "+Name+" "+Basic+" "+DeptNo);
        }
    }
}
