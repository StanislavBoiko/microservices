using Microsoft.AspNetCore.Mvc;
using MVCClient.Models;

namespace MVCClient.Controllers;

public class UserController : Controller
{
    public IActionResult Create()
    {
        return View();
    }

    [HttpPost]
    public IActionResult Create(User user)
    {
        using (var client = new HttpClient())
        {
            client.BaseAddress = new Uri("http://192.168.49.2:80/api/");
            var postTask = client.PostAsJsonAsync<User>("user", user);
            postTask.Wait();
            return RedirectToAction("Index", "Home");
        }
    }
}