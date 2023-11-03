namespace Domain.DTOs;

public class UserLoginDto
{
    public long CprNumber { get; init; }
    public string Password { get; init; }

    public UserLoginDto(long cpr, string password)
    {
        CprNumber = cpr;
        Password = password;
    }
}