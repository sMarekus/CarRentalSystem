using Domain.Models;

namespace Domain.DTOs;

public class UserCreationDto
{
    public string FirstName { get;  }
    public string LastName { get;  }
    public string Email { get;  }
    public string Password { get;  }
    public string UserName { get;  }
    public long PhoneNumber { get;  }
    public bool IsAdmin { get;  }


    public UserCreationDto(string firstName, string lastName, string email, string password, string userName, long phoneNumber, bool isAdmin)
    {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        UserName = userName;
        PhoneNumber = phoneNumber;
        IsAdmin = isAdmin;
    }
}