namespace Domain.DTOs;

public class UserUpdateDto
{
    public string FirstName { get;set;}
    public string LastName { get;set;}
    public string Email { get; set;}
    public string Password { get;set;}
    public string UserName { get;set;}
    public long PhoneNumber { get;set;}
    public bool IsAdmin { get;set;}
}