using Microsoft.Data.SqlClient;
using System.Data;

namespace StudentDemoProject.Models
{
    public class Teacher
    {
        public int Id { get; set; }
        public string Name { get; set; }


        public static List<Teacher> getAllTeachers()
        {
            SqlConnection conn = new SqlConnection();
           
            List<Teacher> list = new List<Teacher>();

            try
            {
                conn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=DemoLearn;Integrated Security=True;";
                conn.Open();
                SqlCommand cmd = conn.CreateCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from teacher";

                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    list.Add(new Teacher { Id = reader.GetInt32("Id"),Name=reader.GetString("Name") });

                }
                reader.Close();

            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                conn.Close();
            }

            return list;
        }

    }
    
}
