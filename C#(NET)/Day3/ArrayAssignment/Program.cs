using System.Security.Cryptography.X509Certificates;

namespace ArrayAssignment
{
    internal class Program
    {
        static void Main1(string[] args)
        {

            //not completed this assignment yet to complete......
            Console.WriteLine("Enter how many batches you want");
            int n=int.Parse(Console.ReadLine()!);
            CDAC[] cdac=new CDAC[n];
            for (int i = 0; i < cdac.Length; i++)
            {
                string batch=Console.ReadLine()!;
                string sub=Console.ReadLine()!;
                int marks=int.Parse(Console.ReadLine()!);

                batch = Console.ReadLine()!;
                cdac[i] = new Student(sub,marks,batch);
                Console.Write($"enter students details for batch[{i}] : ");  //string interpolatio 
            }
        

        }

        public class CDAC
        {
            private string batch;
            public string Batch
            {
                get { return batch; }
                set { batch = value; }
            }
            public CDAC(string batch)
            {
                this.batch = batch;
            }
        }

        public class Student : CDAC
        {
            private string sub;
            public string Sub { get { return sub; } set { sub = value; } }

            private int marks;
            public int Marks { get { return marks; } set { marks = value; } }

            public Student(string sub, int marks,string batch):base(batch)
            {
                this.sub = sub;
                this.marks = marks;
            }
        }
    }
    internal class Program1
    {
        static void Main(string[] args)

        {
            Console.WriteLine("How many Employee??????");
            int n=int.Parse(Console.ReadLine()!);    
            Employee[] emp=new Employee[n];

            for(int i = 0; i < n; i++)
            {
                Console.WriteLine($"Enter {i+1} name: ");
                string name = Console.ReadLine()!;
                Console.WriteLine($"Enter {i + 1} salary: ");
                decimal basic=decimal.Parse(Console.ReadLine()!);
                Console.WriteLine($"Enter {i + 1} DeptNo: ");
                short deptNo=short.Parse(Console.ReadLine()!);
                emp[i]=new Employee(name, basic, deptNo);
            }

            Employee e1 = emp[0];
            foreach(Employee e in emp)
            {
                if (e.Basic > e1.Basic)
                {
                    e1 = e;
                }
            }
            Console.WriteLine("Highest Salary Emp: "+e1.ToString());


            Console.WriteLine("Give a empNo to be search: ");
            int m=int.Parse(Console.ReadLine()!);
            if (m > n)
            {
                Console.WriteLine("Not found here buddy");

            }
            else
            {
                for (int i = 0; i < n; ++i)
                {
                    if (emp[i].EmpNo == m)
                    {
                        Console.WriteLine("search FOund: " + emp[i].ToString());
                        break;
                    }
                }
            }
        }
 
    }

    public class Employee
    {

        string name; 
        int empNo; 
        decimal basic;
        short deptNo;
        static int count;
        public Employee(string Name = "default", decimal Basic = 20000, short DeptNo = 10)
        {
            empNo = ++count;
            this.Name = Name;
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
                if (value < 1000 || value > 100000)
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

        public override string ToString()
        {
            return EmpNo + " " + Name + " " + Basic + " " + DeptNo;
        }

    }

}
