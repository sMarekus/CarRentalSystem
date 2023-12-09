namespace Domain.DTOs;

public class UserUpdateDto
{
    public string UserName { get;set;}
    public string FirstName { get;set;}
    public string LastName { get;set;}
    public string Email { get; set;}
    public long PhoneNumber { get;set;}
    public bool IsAdmin { get;set;}
}