using Domain.Model;

namespace HTTPServices.Interfaces;

public interface IUserService
{
    Task<User> CreateUserAsync(User user);
}