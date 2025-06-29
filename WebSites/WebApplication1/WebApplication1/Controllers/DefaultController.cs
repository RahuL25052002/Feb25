using Microsoft.AspNetCore.Mvc;

namespace WebApplication1.Controllers
{
    public class DefaultController : Controller
    {

        //https://localhost:7141/Default/index/2?a=2&b=3&c-2
        public IActionResult Index(int? id,int a=30,int b=20,int c=10)
        {
            ViewBag.id=id;//dynamic coding 
            ViewBag.a=a;
            ViewBag.b=b;
            ViewBag.c=c;
            return View();
            //return View("nameOfTheView");
        }
    }
}
