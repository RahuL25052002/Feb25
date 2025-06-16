using System.ComponentModel.DataAnnotations;

namespace Day2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            Employee o1 = new Employee(1, "Rahul", 12333, 10);
            o1.display();
            Console.WriteLine("Name: "+ o1.Name+" NetSalary: "+ o1.GetNetSalary());

          
           
            //Employee o2 = new Employee(-1, "Rahul", 12333, -1);
            Employee o2 = new Employee(1, "Amol", 123465);
            o2.display();
            Employee o3 = new Employee(1, "Amol");
            o3.display();
            Employee o4 = new Employee(1);
            o4.display();
            Employee o5 = new Employee();
            o5.display();


        }
    }
    internal class Employee
    {
        private int empNo;
        public int EmpNo
        {
            set
            {
                if (value > 0)
                {
                    empNo=value;
                }
                else
                {
                    Console.WriteLine("Invalid EmpNo");
                }
            }
            get
            {
                return empNo;
            }
        }
        public string Name { get; set; }
        decimal Basic { get; set; }
        private short deptNo;
        public short Deptno
        {
            set
            {
                if (value > 0)
                {
                    deptNo=value;
                }
                else
                {
                    Console.WriteLine("Invalid dept id");
                }
            }
            get
            {
                return deptNo;
            }
        }

        public Employee() { }
        public Employee(int empNo = 1,String Name="", decimal Basic = 0, short deptno = 1)
        {
            this.EmpNo=empNo;
            this.Name=Name;
            this.Basic=Basic;
            this.Deptno=deptno;
        }
        public void display()
        {
            Console.WriteLine(empNo+"  "+Name+"  "+Basic+" "+this.Deptno);
        }

        public decimal GetNetSalary()
        {
            decimal hra = 0.20m * this.Basic;
            decimal da = 0.10m * this.Basic;
            decimal pf = 0.05m * this.Basic;
            decimal tax = 0.08m * this.Basic;

            decimal netSalary = this.Basic + hra + da - pf - tax;
            return netSalary;
        }
    }
}
