using Domain.Models;

namespace Domain.DTOs;

public class UserCreationDto
{
    public string FirstName { get;  }
    public string LastName { get;  }
    public string Email { get;  }
    public string Password { get;  }
    public long CprNumber { get;  }
    public long PhoneNumber { get;  }
    public bool IsAdmin { get;  }


    public UserCreationDto(string firstName, string lastName, string email, string password, long cprNumber, long phoneNumber, bool isAdmin)
    {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        CprNumber = cprNumber;
        PhoneNumber = phoneNumber;
        IsAdmin = isAdmin;
    }
}