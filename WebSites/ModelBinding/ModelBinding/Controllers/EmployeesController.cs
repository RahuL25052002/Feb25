using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ModelBinding.Models;

namespace ModelBinding.Controllers
{
    public class EmployeesController : Controller
    {
        // GET: EmployeesController
        //Employees/Index
        public ActionResult Index()
        {
            //List<Employee> emps = new List<Employee>();
            //emps.Add(new Employee { EmpNo = 1, Name = "Rahul", Basic = 123433, DeptNo = 10 });
            //emps.Add(new Employee { EmpNo = 2, Name = "Sai", Basic = 33333, DeptNo = 20 });
            //emps.Add(new Employee { EmpNo = 3, Name = "Sham", Basic = 1433, DeptNo = 10 });

            List<Employee> emps=Employee.GetAllEmployees();

            //return View(emps);
            return View(emps);
        }

        // GET: EmployeesController/Details/5
        //Employees/Details/id
        //[HttpGet] bydefault it get GET method
        public ActionResult Details(int id)
        {
            Employee obj =Employee.GetSingleEmployee(id);
            //Employee obj=new Employee();
            //obj.EmpNo = id;
            //obj.Name = "Ahan";
            //obj.Basic = 12345;
            //obj.DeptNo = 10;
            return View(obj);//it go to the view Details
        }

        // GET: EmployeesController/Create
        //Employees/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: EmployeesController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeesController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: EmployeesController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeesController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: EmployeesController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
