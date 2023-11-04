namespace Entity.Model;

public class UserEntity
{
    public long Cpr { get; }
    public string FirstName { get; }
    public string LastName { get; }
    public string Email { get; }
    public string password { get; }
    public long PhoneNumber { get; }
    public bool isAdmin { get; }
    
    public UserEntity(long cpr, string firstName, string lastName, string email, string password, long phoneNumber, bool isAdmin)
    {
        Cpr = cpr;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        this.password = password;
        PhoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
    }
}