using Microsoft.AspNetCore.Mvc;
using MVCClient.Models;

namespace MVCClient.Controllers;

public class ProductController : Controller
{
    
    
    public IActionResult Create()
    {
        return View();
    }

    [HttpPost]
    public IActionResult Create(Product product)
    {
        using (var client = new HttpClient())
        {
            client.BaseAddress = new Uri("http://192.168.49.2:80/api/");
            var postTask = client.PostAsJsonAsync<Product>("product", product);
            postTask.Wait();
            return RedirectToAction("Index", "Home");
        }
    }
}