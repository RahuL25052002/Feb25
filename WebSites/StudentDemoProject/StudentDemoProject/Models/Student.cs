
using Microsoft.Data.SqlClient;
using System.Data;
namespace StudentDemoProject.Models
{
    public class Student
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Marks { get; set; }

        public static Student GetStudent(int id)
        {
            SqlConnection conn = new SqlConnection();

            Student student = null;
    
            try
            {
              
                //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=DemoLearn;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=DemoLearn;Integrated Security=True;";
                conn.Open();
                SqlCommand cmd = conn.CreateCommand();

                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Student where Id=@Id";
                cmd.Parameters.AddWithValue("@Id",id);
               
                SqlDataReader dr = cmd.ExecuteReader();

                while (dr.Read())
                {
                    int Stud_id = dr.GetInt32("Id");
                    string name=dr.GetString("Name");
                    int marks = dr.GetInt32("Marks");

                    student=new Student { Id = Stud_id, Name = name, Marks = marks };
                }
                dr.Close();
            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                conn.Close();
            }
            return student;
        }

        public static List<Student> GetAllStudent()
        {
            SqlConnection conn = new SqlConnection();

            List<Student> student = new List<Student>();

            try
            {

                //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=DemoLearn;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=DemoLearn;Integrated Security=True;";
                conn.Open();
                SqlCommand cmd = conn.CreateCommand();

                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Student";
             

                SqlDataReader dr = cmd.ExecuteReader();

                while (dr.Read())
                {
                    int Stud_id = dr.GetInt32("Id");
                    string name = dr.GetString("Name");
                    int marks = dr.GetInt32("Marks");

                    student.Add(new Student { Id = Stud_id, Name = name, Marks = marks });
                }
                dr.Close();
            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                conn.Close();
            }
            return student;
        }

        public static void Update(int id)
        {
            Student student =Student.GetStudent(id);
            if (student == null)
            {
                throw new Exception("Invalid id");
            }
            SqlConnection con = new SqlConnection();
            try
            {
                con.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=DemoLearn;Integrated Security=True;";

                con.Open();
                SqlCommand cmd = con.CreateCommand();
                cmd.Connection = con;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "update Student set Name=@Name, Marks=@Marks where Id=@Id";
                cmd.Parameters.AddWithValue("@Name", student.Name);
                cmd.Parameters.AddWithValue("@Marks", student.Marks);
                cmd.Parameters.AddWithValue("@Id", id);
                cmd.ExecuteNonQuery();

            }
            catch (Exception ex)
            {

                throw;
            }
            finally
            {
                con.Close();
            }
        }

    }

    
}
