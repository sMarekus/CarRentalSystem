namespace Domain.DTOs;

public class UserLoginDto
{
    public string UserName { get; init; }
    public string Password { get; init; }

    public UserLoginDto(string username, string password)
    {
        UserName = username;
        Password = password;
    }
}