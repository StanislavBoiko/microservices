namespace MVCClient.Models;

public class IndexVM
{
    public IEnumerable<User> Users { get; set; }
    public IEnumerable<Product> Products { get; set; }
}