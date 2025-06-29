using System.Data;
using Microsoft.Data.SqlClient;
namespace ModelBinding.Models
{
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }

        public static Employee GetSingleEmployee(int EmpNo)
        {
            Employee a = null;
            SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees where EmpNo=@EmpNo";
                cmd.Parameters.AddWithValue("@EmpNo", EmpNo);



                SqlDataReader reader = cmd.ExecuteReader();

                if (reader.Read())
                {
                    int id = reader.GetInt32("EmpNo");
                    string name = reader.GetString("Name");
                    decimal salary = reader.GetDecimal("Basic");
                    int dept = reader.GetInt32("DeptNo");
                    a = new Employee(id, name, salary, dept);
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                //Console.WriteLine("Error: " + ex.Message);
                throw;
            }
            finally
            {
                conn.Close();
            }
            return a;
        }


        public static List<Employee> GetAllEmployees()
        {
            List<Employee> employees = new List<Employee>();
            SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees";



                SqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    int id = reader.GetInt32("EmpNo");
                    string name = reader.GetString("Name");
                    decimal salary = reader.GetDecimal("Basic");
                    int dept = reader.GetInt32("DeptNo");
                    employees.Add(new Employee(id, name, salary, dept));

                    //Console.WriteLine($"ID: {id}, Name: {name}, Salary: {salary}, Dept: {dept}");
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                //Console.WriteLine("Error: " + ex.Message);
                throw;
            }
            finally
            {
                conn.Close();
            }
            return employees;
        }
        public Employee(int empNo, string name, decimal basic, int deptNo)
        {
            EmpNo = empNo;
            Name = name;
            Basic = basic;
            DeptNo = deptNo;
        }

        public override string ToString()
        {
            return $" EmpNo: {EmpNo} Name: {Name} Basic: {Basic} Dept: {DeptNo}";
        }
    }
}
