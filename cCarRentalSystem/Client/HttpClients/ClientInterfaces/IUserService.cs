using System.Security.Claims;
using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IUserService
{
    public Task<User> CreateAsync(UserCreationDto userToCreate);
    public Task UpdateAsync(UserUpdateDto userToUpdate);
    public Task DeleteUserAsync(int userId);
    public Task Logout();
    public Task<IEnumerable<User>> GetUsersAsync(string? usernameContains = null);
    public Task<User> GetUserByUserNameAsync(string username);

    Task<AuthenticationResponse> ValidateUser(string username, string password);
    Action<ClaimsPrincipal> OnAuthStateChanged { get; set; }
    Task<ClaimsPrincipal> GetAuthAsync();
}