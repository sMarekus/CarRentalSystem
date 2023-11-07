using Domain.Models;

namespace Domain.DTOs;

public class UserCreationDto
{
    public string Name { get; }
    public string Surname { get; }
    public string Email { get; }
    public long Cpr { get; }
    public string Password { get; }
    public string PhoneNumber { get; }
    public bool IsAdmin { get; }


    public UserCreationDto(string name, string surname,string email, string password, long cpr, string phoneNumber, bool isAdmin)
    {
        Cpr = cpr;
        Name = name;
        Surname = surname;
        Password = password;
        Email = email;
        PhoneNumber = phoneNumber;
        IsAdmin = isAdmin;
    }
}