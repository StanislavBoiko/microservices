using System.Collections;
using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using MVCClient.Models;
using Newtonsoft.Json;

namespace MVCClient.Controllers;

public class HomeController : Controller
{
    

    public IActionResult Index()
    {
        IndexVM indexVm = new IndexVM();
        
        IEnumerable<User> users = null;

        using (var client = new HttpClient())
        {
            client.BaseAddress = new Uri("http://192.168.49.2:80/api/");
            //HTTP GET
            var responseTask = client.GetAsync("user");
            responseTask.Wait();

            var result = responseTask.Result;
            
            var readTask = result.Content.ReadAsStringAsync();
            readTask.Wait();

            string res = readTask.Result;

            users = JsonConvert.DeserializeObject<IEnumerable<User>>(res);
            
            
        }
        
        IEnumerable<Product> products = null;

        using (var client = new HttpClient())
        {
            client.BaseAddress = new Uri("http://192.168.49.2:80/api/");
            //HTTP GET
            var responseTask = client.GetAsync("product");
            responseTask.Wait();

            var result = responseTask.Result;
            
            var readTask = result.Content.ReadAsStringAsync();
            readTask.Wait();

            string res = readTask.Result;

            products = JsonConvert.DeserializeObject<IEnumerable<Product>>(res);
            
            
        }

        indexVm.Users = users;
        indexVm.Products = products;
        
        return View(indexVm);
    }

    
    

    
}