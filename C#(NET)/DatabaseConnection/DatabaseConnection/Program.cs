using Microsoft.Data.SqlClient;
using System.Data;
namespace DatabaseConnection
{
    internal class Program
    {
        static void Main()
        {

            //Connect();
            //Insert();
            //Update();
            Employee employee = new Employee { EmpNo = 6, Name = "Shweta", Basic = 10000, DeptNo = 10 };
            //Insert(employee);
            //InsertWithParameter(employee);
            //InsertWithStoredProcedure(employee);
            //Update(employee);
            //UpdateSP(employee);
            //Delete(6);
            DeleteSP(7);
            SelectByDeptId(10);
            SelectByEmpNo(2);
            Select();
        }

        static void Update()
        {
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                //SqlCommand cmd = conn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "insert into Employees values(3,'shital',25000,20)";

                cmd.ExecuteNonQuery();
                Console.WriteLine("Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);

            }
            finally
            {
                conn.Close();
            }

        }
        static void Insert()
        {
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                //SqlCommand cmd = conn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType=CommandType.Text;
                cmd.CommandText = "insert into Employees values(3,'shital',25000,20)";

                cmd.ExecuteNonQuery();
                Console.WriteLine("Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);

            }
            finally
            {
                conn.Close();
            }

        }

        static void Insert(Employee obj)
        {
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                //SqlCommand cmd = conn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = $"insert into Employees values({obj.EmpNo},'{obj.Name}',{obj.Basic},{obj.DeptNo})";

                cmd.ExecuteNonQuery();
                Console.WriteLine("Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);

            }
            finally
            {
                conn.Close();
            }

        }

        static void InsertWithParameter(Employee obj)
        {
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                //SqlCommand cmd = conn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo)";
                cmd.Parameters.AddWithValue("@Id", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

                cmd.ExecuteNonQuery();
                Console.WriteLine("Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);

            }
            finally
            {
                conn.Close();
            }

        }

           static void InsertWithStoredProcedure(Employee obj)
        {
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                //SqlCommand cmd = conn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.StoredProcedure;//change
                cmd.CommandText = "InsertEmployee";
                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

                cmd.ExecuteNonQuery();
                Console.WriteLine("Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);

            }
            finally
            {
                conn.Close();
            }

        }
        static void Connect()
        {
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
            SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();
                Console.WriteLine("Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);

            }
            finally
            {
                conn.Close();
            }
            
        }



        //update and delete with stored procedure and parameters

        static void Update(Employee obj)
        {
            SqlConnection conn = new SqlConnection();//sqlConnect obj
            try
            {
                //connect to databasr
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                //SqlCommand cmd = conn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "update Employees set Name=@Name, Basic=@Basic, DeptNo=@DeptNo where EmpNo=@EmpNo";
                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

                cmd.ExecuteNonQuery();
                Console.WriteLine("Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);

            }
            finally
            {
                conn.Close();
            }
        }

        static void UpdateSP(Employee obj)
        {
            SqlConnection conn = new SqlConnection();//sqlConnect obj
            try
            {
                //connect to databasr
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                //SqlCommand cmd = conn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "UpdateEmployee";
                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

                cmd.ExecuteNonQuery();
                Console.WriteLine("Success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);

            }
            finally
            {
                conn.Close();
            }
        }

        static void Delete(int EmpNo)
        {
            SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                //SqlCommand cmd = conn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "delete from Employees where EmpNo=@EmpNo";
                cmd.Parameters.AddWithValue("@EmpNo", EmpNo);
              
                cmd.ExecuteNonQuery ();
                Console.WriteLine("Success");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                conn.Close();
            }
        }

        static void DeleteSP(int EmpNo)
        {
           SqlConnection conn = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "DeleteEmployee";
                cmd.Parameters.AddWithValue("@EmpNo", EmpNo);

                cmd.ExecuteNonQuery ();
                Console.WriteLine("Suceess");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }finally { conn.Close(); }
        }


        ///select 
        ///

        static void SelectByDeptId(int DeptNo)
        {
            SqlConnection conn = new SqlConnection();

            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "SELECT EmpNo, Name,Basic, DeptNo FROM Employees WHERE DeptNo = @DeptNo";


                cmd.Parameters.AddWithValue("@DeptNo", DeptNo);

                SqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    int id = reader.GetInt32(0);
                    string name = reader.GetString(1);
                    decimal salary = reader.GetDecimal(2);
                    int dept = reader.GetInt32(3);

                    Console.WriteLine($"ID: {id}, Name: {name}, Salary: {salary}, Dept: {dept}");
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }

        static void SelectByEmpNo(int EmpNo)
        {
            SqlConnection conn = new SqlConnection();

            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "SELECT EmpNo, Name,Basic, DeptNo FROM Employees WHERE EmpNo=@EmpNo";


                cmd.Parameters.AddWithValue("@EmpNo", EmpNo);

                SqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    int id = reader.GetInt32(0);
                    string name = reader.GetString(1);
                    decimal salary = reader.GetDecimal(2);
                    int dept = reader.GetInt32(3);

                    Console.WriteLine($"ID: {id}, Name: {name}, Salary: {salary}, Dept: {dept}");
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }

        static void Select()
        {
            SqlConnection conn = new SqlConnection();

            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "SELECT EmpNo, Name,Basic, DeptNo FROM Employees";



                SqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    int id = reader.GetInt32(0);
                    string name = reader.GetString(1);
                    decimal salary = reader.GetDecimal(2);
                    int dept = reader.GetInt32(3);

                    Console.WriteLine($"ID: {id}, Name: {name}, Salary: {salary}, Dept: {dept}");
                }

                reader.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }
    }

    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
    }
}
