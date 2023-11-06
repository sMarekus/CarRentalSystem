using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IUserService
{
    public Task<User> CreateAsync(UserCreationDto userToCreate);
    public Task DeleteUserAsync(int userId);
    public Task<IEnumerable<User>> GetUsersAsync(string? usernameContains = null);
    public Task<User> GetUserByCprAsync(long cprNumber);
}