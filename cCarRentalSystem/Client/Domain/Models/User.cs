namespace Domain.Models;

public class User
{
    //public int Id { get; set; }
    public long Cpr { get; set; }
    public string Name { get; set; }
    public string Surname { get; set; }
    public string Password { get; set; }
    public bool IsAdmin { get; set; }
    
}