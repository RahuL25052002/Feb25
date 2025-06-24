using System.Diagnostics;
using System.Reflection.Metadata.Ecma335;

namespace LinqExample
{
    internal class Program
    {
        static List<Employee> lstEmp = new List<Employee>();
        static List<Department> lstDept = new List<Department>();

        public static void AddRecs()
        {
            lstDept.Add(new Department { DeptNo = 10, DeptName = "SALES" });
            lstDept.Add(new Department { DeptNo = 20, DeptName = "MKTG" });
            lstDept.Add(new Department { DeptNo = 30, DeptName = "IT" });
            lstDept.Add(new Department { DeptNo = 40, DeptName = "HR" });

            lstEmp.Add(new Employee { EmpNo = 1, Name = "Vikram", Basic = 10000, DeptNo = 10, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 2, Name = "Vishal", Basic = 11000, DeptNo = 10, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 3, Name = "Abhijit", Basic = 12000, DeptNo = 20, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 4, Name = "Mona", Basic = 11000, DeptNo = 20, Gender = "F" });
            lstEmp.Add(new Employee { EmpNo = 5, Name = "Shweta", Basic = 12000, DeptNo = 20, Gender = "F" });
            lstEmp.Add(new Employee { EmpNo = 6, Name = "Sanjay", Basic = 11000, DeptNo = 30, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 7, Name = "Arpan", Basic = 10000, DeptNo = 30, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 8, Name = "Shraddha", Basic = 11000, DeptNo = 40, Gender = "F" });
        }

        static Employee GetAllEmps(Employee emp)
        {
            return emp;
        }
        static void Main1()
        {
            AddRecs();
            //var retVal = from single_object in collectiion select some data
            //var emps=from emp in lstEmp select emp;
            //o/p(emps) is ienumerable of employee
            //IEnumerable<Employee> emps= from emp in lstEmp select emp;

            var emps = lstEmp.Select(GetAllEmps);
            var emps2 = lstEmp.Select(delegate (Employee emp)//annonymous methods
            {
                return emp;
            });

            var emp3 = lstEmp.Select(emp => emp);//lambda way of writinggggg
            foreach (var item in emp3) {

                Console.WriteLine(item);
            }
        }

        static string GetAllEmpNames(Employee emp)
        {
            return emp.Name;
        }
        static void Main2()
        {
            AddRecs();
            //var retVal = from single_object in collectiion select some data
            //var emps = from emp in lstEmp select emp.Name;
            //var emps = from emp in lstEmp select emp.EmpNo;

            var emps=lstEmp
                .Select(GetAllEmpNames);   
            
            var emps2=lstEmp.Select(delegate(Employee emp)
            {
                return emp.Name;
            });

            var emps3=lstEmp.Select(emp=>emp.Name);
            //IEnumerable<String> emps
            foreach (var item in emps3)
            {
                Console.WriteLine(item);
            }
        }

        static void Main3()
        {
            AddRecs();
           
            var emps = from emp in lstEmp select new { emp.Name, emp.EmpNo };//annonymous class
                                                                             //IEnumerable<a> that is annonymou type

            var emp2 = lstEmp.Select(delegate (Employee emp)
            {
                return new { emp.EmpNo, emp.Name };
            });

            var emps3 = lstEmp.Select(emp => new {emp.Name, emp.EmpNo});
            foreach (var item in emps)
            {
                Console.WriteLine(item.Name);
            }
        }
        static void Main00()
        {
            AddRecs();
            var emps = from emp in lstEmp select emp.Name;
            foreach (var item in emps)
            {
                Console.WriteLine();
            }
        }


        static bool IsBasicGreaterThan1000(Employee emp)
        {
            //if (emp.Basic
            //   > 10000)
            //{
            //    return true;
            //}
            //else
            //{
            //    return false;
            //}

            return emp.Basic > 10000;
        }
       static void Main4()
       {
                AddRecs();
                var emps = from emp in lstEmp
                            where emp.Basic > 10000
                            select emp;
        //var emps = from emp in lstEmp
        //           where emp.Basic > 10000 && emp.Basic < 12000
        //           select emp;

        //var emps = from emp in lstEmp
        //           where emp.Name.StartsWith("V")
        //           select emp;

        var emps2 = lstEmp.Where(IsBasicGreaterThan1000);

       var emps3 = lstEmp.Where(delegate (Employee emp)
            {
                return emp.Basic > 10000;
        });

       var emps4 = lstEmp.Where(emp => emp.Basic > 10000);
       var emps5 = lstEmp.Where(emp => emp.Basic > 10000).Select(emp=>emp.Basic);

            //var emps6 = lstEmp.Select(emp => emp.Basic).Where(emp => emp.Basic > 10000);

            foreach (var item in emps)
                {
                    Console.WriteLine(item);
                }
       }


        static void Main5()
        {
            AddRecs();



            var emps = from emp in lstEmp
                           //where emp.Basic > 10000

                       orderby emp.Name
                       select emp;
            // in emps return IOrderedEnumerable<Employee>
            //var emps = from emp in lstEmp
            //           orderby emp.Name descending
            //           select emp;

            //var emps = from emp in lstEmp
            //           orderby emp.DeptNo ascending, emp.Name descending
            //           select emp;


            foreach (var emp in emps)
            {
                Console.WriteLine(emp);
            }

            Console.ReadLine();
        }

        static void Main6()
        {
            AddRecs();
            //var emps = from emp in lstEmp
            //           join dept in lstDept
            //           on emp.DeptNo equals dept.DeptNo
            //           //select new { emp.Name, emp.EmpNo, dept.DeptNo, dept.DeptName };
            //            select new {emp,dept};
            //foreach (var item in emps)
            //{

            //    Console.WriteLine(item);

            //}

            //var emps = from emp in lstEmp
            //           join dept in lstDept
            //           on emp.DeptNo equals dept.DeptNo
            //           //select new { emp.Name, emp.EmpNo, dept.DeptNo, dept.DeptName };
            //           select new { emp.Name, dept.DeptName };

            var emps = from emp in lstEmp
                       join dept in lstDept
                       on emp.DeptNo equals dept.DeptNo
                       //select new { emp.Name, emp.EmpNo, dept.DeptNo, dept.DeptName };
                       select new { emp, dept };


            foreach (var item in emps)
            {
                Console.WriteLine(item);
            }
        }

    }

    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
        public string Gender { get; set; }
        public override string ToString()
        {
            string s = Name + "," + EmpNo.ToString() + "," + Basic.ToString() + "," + DeptNo.ToString();
            return s;
        }
    }
    public class Department
    {
        public int DeptNo { get; set; }
        public string DeptName { get; set; }

        public override string ToString()
        {
            return $"DeptNo-{DeptNo} DeptName-{DeptName}";
        }
    }
}

namespace LinqExample2
{
    internal class Program
    {
        static List<Employee> lstEmp = new List<Employee>();
        static List<Department> lstDept = new List<Department>();

        public static void AddRecs()
        {
            lstDept.Add(new Department { DeptNo = 10, DeptName = "SALES" });
            lstDept.Add(new Department { DeptNo = 20, DeptName = "MKTG" });
            lstDept.Add(new Department { DeptNo = 30, DeptName = "IT" });
            lstDept.Add(new Department { DeptNo = 40, DeptName = "HR" });


            //

            lstEmp.Add(new Employee { EmpNo = 1, Name = "Vikram", Basic = 10000, DeptNo = 10, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 2, Name = "Vishal", Basic = 11000, DeptNo = 10, Gender = "M" });


            lstEmp.Add(new Employee { EmpNo = 3, Name = "Abhijit", Basic = 12000, DeptNo = 20, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 4, Name = "Mona", Basic = 11000, DeptNo = 20, Gender = "F" });
            lstEmp.Add(new Employee { EmpNo = 5, Name = "Shweta", Basic = 12000, DeptNo = 20, Gender = "F" });


            lstEmp.Add(new Employee { EmpNo = 6, Name = "Sanjay", Basic = 11000, DeptNo = 30, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 7, Name = "Arpan", Basic = 10000, DeptNo = 30, Gender = "M" });


            lstEmp.Add(new Employee { EmpNo = 8, Name = "Shraddha", Basic = 11000, DeptNo = 40, Gender = "F" });
        }

        static Employee GetAllEmps(Employee emp)
        {
            return emp;
        }
        static void Main1()
        {
            AddRecs();
            //var emps = from emp in lstEmp select emp;
            var emps = lstEmp.Select(GetAllEmps);
            var emps2 = lstEmp.Select(delegate (Employee emp)
            {
                return emp;
            });
            var emps3 = lstEmp.Select(emp => emp);

            foreach (var item in emps3)
            {
                Console.WriteLine(item);
            }
        }
        static string GetAllEmpNames(Employee emp)
        {
            return emp.Name;
        }
        static void Main2()
        {
            AddRecs();
            //var emps = from emp in lstEmp select emp.Name;
            //var emps = from emp in lstEmp select emp.EmpNo;
            var emps = lstEmp.Select(GetAllEmpNames);
            var emps2 = lstEmp.Select(delegate (Employee emp)
            {
                return emp.Name;
            });
            var emps3 = lstEmp.Select(emp => emp.Name);

            foreach (var item in emps)
            {
                Console.WriteLine(item);
            }
        }
        static void Main3()
        {
            AddRecs();
            var emps = from emp in lstEmp select new { emp.Name, emp.EmpNo };
            var emps2 = lstEmp.Select(delegate (Employee emp)
            {
                return new { emp.Name, emp.EmpNo };
            });
            var emps3 = lstEmp.Select(emp => new { emp.Name, emp.EmpNo });
            foreach (var item in emps)
            {
                Console.WriteLine(item.Name);
            }
        }
        static bool IsBasicGreaterThan10000(Employee emp)
        {
            //if (emp.Basic > 10000)
            //    return true;
            //else
            //    return false;
            return emp.Basic > 10000;
        }

        static void Main4a()
        {
            AddRecs();
            var emps = from emp in lstEmp
                       where emp.Basic > 10000
                       select emp;

            var emps2 = lstEmp.Where(IsBasicGreaterThan10000);
            var emps3 = lstEmp.Where(delegate (Employee emp)
            {
                return emp.Basic > 10000;
            });

            var emps4 = lstEmp.Where(emp => emp.Basic > 10000);

            foreach (var item in emps2)
            {
                Console.WriteLine(item);
            }
        }
        static void Main4()
        {
            AddRecs();

            //var emps1 = lstEmp.Where(emp => emp.Basic > 10000);
            //var emps2 = lstEmp.Where(emp => emp.Basic > 10000).Select(emp=>emp);
            //var emps3 = lstEmp.Select(emp=>emp).Where(emp => emp.Basic > 10000);



            //var emps2 = lstEmp.Where(emp => emp.Basic > 10000).Select(emp => emp.Name);
            //error         //var emps3 = lstEmp.Select(emp => emp.Name).Where(emp => emp.Basic > 10000);
            //always give Where before Select

            var emps2a = lstEmp.Where(emp => emp.Basic > 10000).Select(emp => emp.Basic);
            //error//var emps3a = lstEmp.Select(emp => emp.Basic).Where(emp => emp.Basic > 10000);
            //not an error, but dont use this//var emps4a = lstEmp.Select(emp => emp.Basic).Where(emp => emp > 10000);


            //foreach (var item in emps1)
            //{
            //    Console.WriteLine(item);
            //}
        }
        static void Main5()
        {
            AddRecs();

            var emps = from emp in lstEmp
                           //where emp.Basic > 10000
                       orderby emp.Name
                       select emp;

            var emps2 = lstEmp.OrderBy(emp => emp.Name);
            var emps3 = lstEmp.OrderByDescending(emp => emp.Name);


            //var emps = from emp in lstEmp
            //           orderby emp.Name descending
            //           select emp;

            //var emps = from emp in lstEmp
            //           orderby emp.DeptNo ascending, emp.Name descending
            //           select emp;
            var emps4a = lstEmp.OrderBy(emp => emp.DeptNo).OrderByDescending(emp => emp.Name); //error - dont use this
            var emps4 = lstEmp.OrderBy(emp => emp.DeptNo).ThenByDescending(emp => emp.Name);

            foreach (var emp in emps4a)
            {
                Console.WriteLine(emp);
            }

            Console.ReadLine();
        }
        static void Main6 ()
        {
            AddRecs();
            //var emps = from emp in lstEmp
            //           join dept in lstDept
            //           on emp.DeptNo equals dept.DeptNo
            //           select new { emp, dept };

            //var emps = from  in 
            //           join  in 
            //           on  equals 
            //           select;

            var emps = lstEmp.Join(lstDept, emp => emp.DeptNo,
                dept => dept.DeptNo, (emp, dept) => new { emp, dept });

            var emps2 = lstEmp.Join(lstDept, 
                emp => emp.DeptNo,
                dept => dept.DeptNo, 
                (emp, dept) => new { emp, dept }
                );


            foreach (var item in emps)
            {
                Console.WriteLine(item.emp.EmpNo);
                Console.WriteLine(item.dept.DeptName);
            }
            //var emps = from emp in lstEmp
            //           join dept in lstDept
            //           on emp.DeptNo equals dept.DeptNo
            //           select new { emp.Name, dept.DeptName };

            //foreach (var item in emps)
            //{
            //    Console.WriteLine(item.Name);
            //    Console.WriteLine(item.DeptName);
            //}
        }
        //Single
        static void Main7()
        {
            AddRecs();
            //Employee emp = lstEmp.Single(e => e.EmpNo == 1); //one record = okay//not foind throw an error
            //Employee emp = lstEmp.Single(e => e.EmpNo == 10);  //no records = error
            //Employee emp = lstEmp.Single(e => e.Basic > 5000); //multiple records - error


            //Employee emp = lstEmp.SingleOrDefault(e => e.EmpNo == 10)!; //one record = okay if not found return nulll
            //Employee emp = lstEmp.SingleOrDefault(e => e.EmpNo == 10); //no records=null
            Employee emp = lstEmp.SingleOrDefault(e =>  e.Basic > 5000);//multiple records - error

            if (emp != null)
                Console.WriteLine(emp.Name + "," + emp.EmpNo);
            else
                Console.WriteLine("not found");
            Console.ReadLine();
        }

        //deferred execution
        static void Main8()
        {
            AddRecs();
            var emps = from emp in lstEmp select emp;//it will not fetch data at time

            Console.WriteLine();
            lstEmp.RemoveAt(0);

            foreach (var emp in emps)
            {
                Console.WriteLine(emp.Name + "," + emp.EmpNo);
            }
            Console.ReadLine();


            Console.WriteLine();
            lstEmp.Add(new Employee { EmpNo = 9, Name = "New", Basic = 11000, DeptNo = 40, Gender = "F" });
            foreach (var emp in emps)
            {

                Console.WriteLine(emp.Name + "," + emp.EmpNo);
            }
            Console.ReadLine();
        }

        //immediate execution
        static void Maindef()
        {
            AddRecs();
            var emps = from emp in lstEmp select emp;//it wiill work as deffered execution
                                                     //var emps = (from emp in lstEmp select emp).ToList();

            lstEmp.RemoveAt(0);
            foreach (var emp in emps)
            {
                Console.WriteLine(emp.Name + "," + emp.EmpNo);
            }
            Console.ReadLine();
            //immediate execution
            emps = emps.ToList();  //.ToArray .ToDictionary
            //Employee [] arrEmps = emps.ToArray();
            //Dictionary<int, Employee> d = emps.ToDictionary(e => e.EmpNo);

            Console.WriteLine();
            lstEmp.RemoveAt(0);
            foreach (var emp in emps)
            {
                Console.WriteLine(emp.Name + "," + emp.EmpNo);
            }
            Console.ReadLine();
            Console.WriteLine();
            lstEmp.Add(new Employee { EmpNo = 9, Name = "New", Basic = 11000, DeptNo = 40, Gender = "F" });
            foreach (var emp in emps)
            {
                Console.WriteLine(emp.Name + "," + emp.EmpNo);
            }
            Console.ReadLine();
        }

        //simple group
        static void Maingroip()
        {
            AddRecs();
            var emps = from emp in lstEmp
                       group emp by emp.DeptNo;
            foreach (var item in emps)
            {
                Console.WriteLine(item.Key); //deptno
                foreach (var e in item)  //e is an Employee, item is a grouping of Employee
                {
                    Console.WriteLine(e);
                }
                Console.WriteLine();
            }
            Console.ReadLine();
        }

        //group with name
        static void Maingroupname()
        {
            AddRecs();
            var emps = from emp in lstEmp
                       group emp by emp.DeptNo into group1//
                       select group1;


            foreach (var item in emps)
            {
                Console.WriteLine(item.Key); //deptno
                foreach (var e in item)  //e is an Employee, item is a grouping of Employee
                {
                    Console.WriteLine(e);
                }
                Console.WriteLine();
            }

            Console.ReadLine();
        }

        //group with properties
        static void Mainprop()
        {
            AddRecs();

            var emps = from emp in lstEmp
                       group emp by emp.DeptNo into group1
                       select new { group1, Count = group1.Count(), Max = group1.Max(x => x.Basic), Min = group1.Min(x => x.Basic) };


            foreach (var item in emps)
            {
                Console.WriteLine(item.group1.Key); //DeptNo
                Console.WriteLine(item.Count); //count
                Console.WriteLine(item.Min); //min
                Console.WriteLine(item.Max); //max
                //emp.group1.Key;  //DeptNo

                foreach (var e in item.group1)  //e is an Employee
                {
                    Console.WriteLine(e);
                }
                Console.WriteLine();
            }

            Console.ReadLine();

        }
        //plinq
        static void Maindd()
        {
            //AddRecs();
            AddRecs2();
            //plinq example

            Stopwatch stopwatch = new Stopwatch();

            stopwatch.Start();
            //var emps = lstEmp.Select(emp => new { Name = LongRunningFunc(emp.Name), emp.EmpNo });
            var emps = lstEmp.AsParallel().WithDegreeOfParallelism(2).Select(emp => new { Name = LongRunningFunc(emp.Name), emp.EmpNo });
            //var emps = lstEmp.AsParallel().Select(emp => new { Name = LongRunningFunc(emp.Name), emp.EmpNo });
            //var emps = lstEmp.AsParallel().AsOrdered().Select(emp => new { Name = LongRunningFunc(emp.Name), emp.EmpNo });
            //var emps = lstEmp.AsParallel().AsOrdered().WithDegreeOfParallelism(2).Select(emp => new { Name = LongRunningFunc(emp.Name), emp.EmpNo });

            //var emps2 = lstEmp.AsParallel();

            //Console.WriteLine("Elapsed Time is {0} ms", stopwatch.ElapsedMilliseconds);
            foreach (var emp in emps)
            {
                Console.WriteLine(emp.Name + "," + emp.EmpNo);
            }
            stopwatch.Stop();
            Console.WriteLine("Elapsed Time is {0} ms", stopwatch.ElapsedMilliseconds);


        }
        public static void AddRecs2()
        {
            for (int i = 0; i < 200; i++)
            {
                lstEmp.Add(new Employee { EmpNo = i + 1, Name = "Vikram" + i, Basic = 10000, DeptNo = 10, Gender = "M" });
            }
        }
        public static string LongRunningFunc(string s)
        {
            System.Threading.Thread.Sleep(10);
            return s.ToUpper();
        }
    }

    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
        public string Gender { get; set; }
        public override string ToString()
        {
            string s = Name + "," + EmpNo.ToString() + "," + Basic.ToString() + "," + DeptNo.ToString();
            return s;
        }
    }
    public class Department
    {
        public int DeptNo { get; set; }
        public string DeptName { get; set; }

        public override string ToString()
        {
            return $"DeptNo-{DeptNo} DeptName-{DeptName}";
        }
    }
}
