using System.ComponentModel.DataAnnotations;

namespace Entity.Model;

public class UserEntity
{
    [Key]
    public long Cpr { get; set; }
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public string Email { get; set; }
    public string Password { get; set; }
    public long PhoneNumber { get; set; }
    public bool IsAdmin { get; set; }
    
    public UserEntity(long cpr, string firstName, string lastName, string email, string password, long phoneNumber, bool isAdmin)
    {
        Cpr = cpr;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        PhoneNumber = phoneNumber;
        IsAdmin = isAdmin;
    }
}