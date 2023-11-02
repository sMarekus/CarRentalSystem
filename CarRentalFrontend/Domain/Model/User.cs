namespace Domain.Model;

public class User
{
    private string FirstName { get; }
    private string LastName { get; }
    private string Email { get; }
    private string Password { get; }
    private int CPRNumber { get; }
    private int PhoneNumber { get; }


    public User(string firstName, string lastName, string email,string password,int cprNumber,int phoneNumber)
    {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        CPRNumber = cprNumber;
        PhoneNumber = phoneNumber;
    }

}