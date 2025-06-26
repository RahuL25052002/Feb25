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
            //Employee employee = new Employee { EmpNo = 6, Name = "Shweta", Basic = 10000, DeptNo = 10 };
            //Insert(employee);
            //InsertWithParameter(employee);
            //InsertWithStoredProcedure(employee);
            //Update(employee);
            //UpdateSP(employee);
            //Delete(6);
            //DeleteSP(7);
            //SelectByDeptId(10);
            //SelectByEmpNo(2);
            //Select();
            //List<Employee> allEmployees= GetAllEmployees();
            //foreach (var item in allEmployees)
            //{
            //    Console.WriteLine(item.ToString());
            //}

            //Employee single = SingleEmployee(550);
            //if (single != null)
            //    Console.WriteLine(single.ToString());
            //else
            //    Console.WriteLine("Not have Employee");

            //ExecuteScalerDemo();

            //MultipleDataGet();

            //callFuncReturnSqlDataReader();

            Transactions();
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

        static List<Employee> GetAllEmployees()
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
                cmd.CommandText = "SELECT * FROM Employees";



                SqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    int id = reader.GetInt32(0);
                    string name = reader.GetString(1);
                    decimal salary = reader.GetDecimal(2);
                    int dept = reader.GetInt32(3);
                    employees.Add(new Employee(id,name,salary,dept));

                    //Console.WriteLine($"ID: {id}, Name: {name}, Salary: {salary}, Dept: {dept}");
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
            return employees;
        }

        static Employee SingleEmployee(int EmpNo)
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
                cmd.CommandText = "SELECT * FROM Employees where EmpNo=@EmpNo";
                cmd.Parameters.AddWithValue("@EmpNo", EmpNo);



                SqlDataReader reader = cmd.ExecuteReader();

                if (reader.Read())
                {
                    int id = reader.GetInt32(0);
                    string name = reader.GetString(1);
                    decimal salary = reader.GetDecimal(2);
                    int dept = reader.GetInt32(3);
                    a=new Employee(id,name,salary, dept);
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
            return a;
        }

        static void ExecuteScalerDemo()
        {
            SqlConnection conn
                            = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees where EmpNo=1";

                object ans=cmd.ExecuteScalar();//only give first row and first column value

                if (ans != null)
                {
                    Console.WriteLine(ans);
                }

                //SqlDataReader reader = cmd.ExecuteReader();
                //if (reader.Read())
                //{
                //    string name=reader.GetString(0);
                //    //decimal salary=reader.GetDecimal(2);
                //    //int dept=reader.GetInt32(3);
                //    Console.WriteLine(name+" ");
                        
                //}
              

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

        static void MultipleDataGet()
        {
            SqlConnection conn
                            = new SqlConnection();
            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees; select * from Departments ";

                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    int id = reader.GetInt32(0);
                    string name = reader.GetString(1);
                    decimal salary = reader.GetDecimal(2);
                    int dept = reader.GetInt32(3);
                    Console.WriteLine(id+" "+name+" "+salary+" "+dept);
                }

                Console.WriteLine("-----------------------------");
                bool ans=reader.NextResult();

                while (reader.Read())
                {
                    int id = reader.GetInt32(0);
                    string name = reader.GetString(1);
                    Console.WriteLine(id + " " + name);
                }

                reader.Close();

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

        static void MARS()
        {
            SqlConnection conn
                            = new SqlConnection();
            try
            {
              
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

        static void callFuncReturnSqlDataReader()
        {
            SqlDataReader reader = GetSQLDataReader();
            while (reader.Read())
            {
                Console.WriteLine(reader[0]);
                Console.WriteLine(reader[1]);

            }
            reader.Close ();

        }

        static SqlDataReader GetSQLDataReader()
        {
            SqlConnection con = new SqlConnection();
            con.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
            con.Open();
            SqlCommand cmd = con.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "Select * from Employees";
            cmd.ExecuteNonQuery();
            //con.Close();//if send like this it work but we not close the connection
            SqlDataReader sqlDataReader = cmd.ExecuteReader(CommandBehavior.CloseConnection);//when you close the datareader the connction also got close
            //con.Close();
            return sqlDataReader;
            
        }

        static void Transactions()
        {
            SqlConnection sqlConnection = new SqlConnection();
            sqlConnection.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True;";
            sqlConnection.Open();

            SqlTransaction t= sqlConnection.BeginTransaction();

            SqlCommand cmd1 = sqlConnection.CreateCommand();
            cmd1.Connection = sqlConnection;
            cmd1.Transaction = t;
            cmd1.CommandType = CommandType.Text;
            cmd1.CommandText = "insert into employees values(10,'Ram',3900,10);";

            SqlCommand cmd2 = sqlConnection.CreateCommand();
            cmd2.Connection = sqlConnection;
            cmd2.Transaction = t;
            cmd2.CommandType = CommandType.Text;
            cmd2.CommandText = "insert into Employees values(12,'sham',393939,20);";

            try
            {
                cmd1.ExecuteNonQuery();
                cmd2.ExecuteNonQuery();
                t.Commit();
                Console.WriteLine("Suceesss!!!!");
            }
            catch (Exception ex)
            {
                t.Rollback();
                Console.WriteLine(ex.Message);
                Console.WriteLine("Failured.......!!!!!!");
            }
            finally
            {
                sqlConnection.Close();
                Console.WriteLine("Connection Close");
            }
        }
    }


    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
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



//sir code 
namespace Databasecode
{
    internal class Program
    {
        static void Main1()
        {
            //Connect();
            //Insert();

            Employee obj = new Employee { EmpNo = 6, Name = "Alfred D'Mello", DeptNo = 20, Basic = 5000 };
            //Insert2(obj);
            //InsertWithParameters(obj);
            //InsertWithSP(obj);

        }
        static void Main2()
        {
            //SelectASingleValue();
            //SelectMultipleValues();
            //NextResult();
            //MARS();
            // CallFuncReturningSqlDataReader();
            Transactions();
        }
        static void Connect()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
                //cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;User Id=sa;Password=sa";
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();
                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        static void Insert()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();

                // SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "insert into Employees values(3,'Shital', 25000, 20) ";
                cmd.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        static void Insert2(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();

                // SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = $"insert into Employees values({obj.EmpNo},'{obj.Name}', {obj.Basic}, {obj.DeptNo}) ";
                Console.WriteLine(cmd.CommandText);
                Console.ReadLine();
                cmd.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        static void InsertWithParameters(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();

                // SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo)";

                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);


                cmd.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static void InsertWithSP(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";

                cn.Open();

                // SqlCommand cmd = cn.CreateCommand();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "InsertEmployee";

                cmd.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmd.Parameters.AddWithValue("@Name", obj.Name);
                cmd.Parameters.AddWithValue("@Basic", obj.Basic);
                cmd.Parameters.AddWithValue("@DeptNo", obj.DeptNo);


                cmd.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        //TO DO - Update and Delete with SP and Params

        static void SelectASingleValue()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select Name from Employees where EmpNo = 1";
                //cmd.CommandText = "select count(*) from Employees";
                //cmd.CommandText = "select * from Employees";
                object retval = cmd.ExecuteScalar();
                //returns first row, first col
                Console.WriteLine(retval);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static void SelectMultipleValues()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees";
                SqlDataReader dr = cmd.ExecuteReader();
                //dr.HasRows
                while (dr.Read())
                {
                    Console.WriteLine(dr[0]);
                    Console.WriteLine(dr["EmpNo"]);
                    Console.WriteLine(dr["Name"]);
                }
                dr.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        static void NextResult()
        {
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune25;Integrated Security=True";
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees;select * from Departments";

                SqlDataReader dr = cmd.ExecuteReader();
                //dr.HasRows
                while (dr.Read())
                {
                    Console.WriteLine(dr[0]);
                    Console.WriteLine(dr["EmpNo"]);
                    Console.WriteLine(dr["Name"]);
                }

                dr.NextResult(); //t/f


                Console.WriteLine("----------");
                while (dr.Read())
                {
                    Console.WriteLine(dr[0]);
                    Console.WriteLine(dr["DeptName"]);
                }

                dr.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        //to do
        static List<Employee> GetAllEmployees()
        {
            List<Employee> lstEmps = new List<Employee>();
            //read all emps from db
            return lstEmps;
        }
        static Employee GetSingleEmployee(int EmpNo)
        {
            Employee emp = new Employee();
            //read emp details from db
            return emp;
        }
        static void MARS()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MsSqlLocalDb;Initial Catalog=JKJune25;Integrated Security=true;MultipleActiveResultSets=true";
            cn.Open();

            SqlCommand cmdDepts = new SqlCommand();
            cmdDepts.Connection = cn;
            cmdDepts.CommandType = CommandType.Text;
            cmdDepts.CommandText = "Select * from Departments";

            SqlCommand cmdEmps = new SqlCommand();
            cmdEmps.Connection = cn;
            cmdEmps.CommandType = CommandType.Text;

            SqlDataReader drDepts = cmdDepts.ExecuteReader();
            while (drDepts.Read())
            {
                Console.WriteLine((drDepts["DeptName"]));
                cmdEmps.CommandText = "Select * from Employees where DeptNo = " + drDepts["DeptNo"];
                SqlDataReader drEmps = cmdEmps.ExecuteReader();
                while (drEmps.Read())
                {
                    Console.WriteLine(("    " + drEmps["Name"]));
                }
                drEmps.Close();
            }
            drDepts.Close();
            cn.Close();

        }
        static void CallFuncReturningSqlDataReader()
        {
            SqlDataReader dr = GetDataReader();
            while (dr.Read())
            {
                Console.WriteLine(dr[1]);
            }
            dr.Close();
        }
        static SqlDataReader GetDataReader()
        {
            SqlConnection cn = new SqlConnection();
            cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";
            cn.Open();
            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.CommandType = System.Data.CommandType.Text;
            cmdInsert.CommandText = "select * from Employees ";
            //SqlDataReader dr = cmdInsert.ExecuteReader();
            SqlDataReader dr = cmdInsert.ExecuteReader(CommandBehavior.CloseConnection);
            //cn.Close();
            return dr;
        }

        static void Transactions()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=JkJune25;Integrated Security=True";
            cn.Open();
            SqlTransaction t = cn.BeginTransaction();

            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.Transaction = t;

            cmdInsert.CommandType = System.Data.CommandType.Text;
            cmdInsert.CommandText = "insert into Employees values(10, 'Shweta', 12345, 30)";

            SqlCommand cmdInsert2 = new SqlCommand();
            cmdInsert2.Connection = cn;
            cmdInsert2.Transaction = t;

            cmdInsert2.CommandType = System.Data.CommandType.Text;
            cmdInsert2.CommandText = "insert into Employees values(1, 'Shweta', 12345, 30)";
            try
            {
                cmdInsert.ExecuteNonQuery();
                cmdInsert2.ExecuteNonQuery();
                t.Commit();
                Console.WriteLine("no errors- commit");
            }
            catch (Exception ex)
            {
                t.Rollback();
                Console.WriteLine("Rollback");
                Console.WriteLine(ex.Message);
            }
            cn.Close();

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
