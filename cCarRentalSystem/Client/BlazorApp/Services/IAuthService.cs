using System.Security.Claims;
using Domain.Models;

namespace BlazorApp.Services;

public interface IAuthService
{
    public Task LoginAsync(long cpr, string password);
    public Task LogoutAsync();
    public Task RegisterAsync(User user);
    public Task<ClaimsPrincipal> GetAuthAsync();

    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; }
}