using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.CodeAnalysis.CSharp.Syntax;
using StudentDemoProject.Models;

namespace StudentDemoProject.Controllers
{
    public class StudentController : Controller
    {
        // GET: StudentController
        public ActionResult Index()
        {
            List<Student> students = Student.GetAllStudent();
            return View(students);
        }

        // GET: StudentController/Details/5
        //Student/Details/id
        public ActionResult Details(int id)
        {
            Student student =Student.GetStudent(id);
            return View(student);
        }

        // GET: StudentController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: StudentController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Student obj)
        {
            try
            {
               Student.Insert(obj);
                ViewBag.message = "Sucess!!!, inserted student data in DB";
                return View();
            }
            catch(Exception ex) 
            {
                 ViewBag.message = ex.Message;
                return View();
            }
        }

        // GET: StudentController/Edit/5
        public ActionResult Edit(int id)
        {
            Student obj =Student.GetStudent(id);
            return View(obj);
        }

        // POST: StudentController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, Student obj)
        {
            try
            {
                Student.Update(obj);
                //Console.WriteLine("Suceees");
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: StudentController/Delete/5
        public ActionResult Delete(int id)
        {
            Student student =Student.GetStudent(id);
            return View(student);
        }

        // POST: StudentController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                Student.Delete(id);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
