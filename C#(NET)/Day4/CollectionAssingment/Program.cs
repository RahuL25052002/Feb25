using System.Collections;
using System.Collections.Generic;

namespace CollectionAssingment
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            //Console.WriteLine("Hello, World!");
            bool flag = true;
            List<Employee> empList = new List<Employee>();
            while (flag)
            {
                Console.WriteLine("do you want to add details!! yes/no: ");
                string s = Console.ReadLine()!;
                if (s == "no" || s == "No" || s == "NO" || s == "nO")
                {
                    flag = false;
                    break;
                }
                Console.WriteLine("Name: ");
                string name = Console.ReadLine()!;
                Console.WriteLine("Salary: ");
                float salary = float.Parse(Console.ReadLine()!);
                Console.WriteLine("dept no: ");
                int deptno = int.Parse(Console.ReadLine()!);

                empList.Add(new Employee(name, salary, deptno));
            }

            //foreach (Employee emp in empList)
            //{
            //    Console.WriteLine(emp.ToString());
            //}
            Employee HighSalary = Employee.HighestSalary(empList);
            Console.WriteLine("Highest Salary Employee:   " + HighSalary.ToString());

            Console.WriteLine("give a Empno to Find in list: ");
            int findEmp = int.Parse(Console.ReadLine()!);
            Employee findEmpByEmpno = Employee.FindEmployeeByEmpNo(empList, findEmp);
            if (findEmpByEmpno != null)
            {
                Console.WriteLine($"Employee details of {findEmp} is: {findEmpByEmpno.ToString()}");
            }
            else
            {
                Console.WriteLine("Not have Employee");
            }

        }

        static void Main()
        {
            Console.WriteLine("How many emp you want to add: ");
            int size = int.Parse(Console.ReadLine()!);
            Employee[] empObj = new Employee[size];
            for (int i = 0; i < size; i++)
            {
                Console.WriteLine("Name: ");
                string name = Console.ReadLine()!;
                Console.WriteLine("Salary: ");
                float salary = float.Parse(Console.ReadLine()!);
                Console.WriteLine("dept no: ");
                int deptno = int.Parse(Console.ReadLine()!);

                empObj[i] = new Employee(name, salary, deptno);

            }
            List<Employee> empList = empObj.ToList();

            foreach (Employee emp in empList)
            {

                Console.WriteLine(emp.ToString());
            }

            Employee[] arrEmp2 = empList.ToArray();

            for (int i = 0; i < arrEmp2.Length; i++)
            {
                Console.WriteLine(arrEmp2[i].ToString());
            }

        }

    }

        
    public class Employee
    {
        static int count = 0;
        private int empNo;
        public int EmpNo
        {
            get { return empNo; }
            set { empNo = value; }
        }
        public string Name { get;set; } 
        public float salary { get; set; }   
        public int DeptNo {  get; set; }

        public Employee()
        {

        }
        public Employee(string Name,float Salary,int DeptNo)
        {
            this.empNo = ++count;
            this.Name = Name;
            this.salary = Salary;
            this.DeptNo = DeptNo;
        }

        public override string ToString()
        {
            return $"EmpNo: {empNo} Name: {Name} Salary: {salary} DeptNo: {DeptNo}";
        }

        public static Employee HighestSalary(List<Employee> empList)
        {
            float max = float.MinValue;
            Employee? e =null;
            foreach (Employee emp in empList)
            {
                if(emp.salary > max)
                {
                    max=emp.salary;
                    e=emp; 
                }
            }
            return e;
        }

        public static Employee FindEmployeeByEmpNo(List<Employee> empList,int empno)
        {
            int size=empList.Count;
            if (size < empno)
            {
                return null;
            }
            foreach
                (Employee emp in empList)
            {
                if (empno == emp.empNo)
                {
                    return emp;
                }
            }
            return null;
        }
    }
}
