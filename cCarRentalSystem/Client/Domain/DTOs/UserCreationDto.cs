using Domain.Models;

namespace Domain.DTOs;

public class UserCreationDto
{
    public long Cpr { get; }
    public string Name { get; }
    public string Surname { get; }
    public string Password { get; }
    public bool IsAdmin { get; }


    public UserCreationDto(long cpr, string name, string surname, string password, bool isAdmin)
    {
        Cpr = cpr;
        Name = name;
        Surname = surname;
        Password = password;
        IsAdmin = isAdmin;
    }
}