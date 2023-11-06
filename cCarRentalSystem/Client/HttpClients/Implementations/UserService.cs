using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class UserService : IUserService
{

    private readonly HttpClient client;

    public UserService(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<User> CreateAsync(UserCreationDto userToCreate)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/users", userToCreate);
        string result = await response.Content.ReadAsStringAsync();
        
        if(!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(result);
        }

        User user = JsonSerializer.Deserialize<User>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return user;
    }

    public async Task DeleteUserAsync(int userId)
    {
        HttpResponseMessage response = await client.DeleteAsync($"users/{userId}");
        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            string content = await response.Content.ReadAsStringAsync();
            throw new Exception(content);
        }
    }

    public async Task<IEnumerable<User>> GetUsersAsync(string? userNameContains = null)
    {
        string uri = "/users";
        
        if (!string.IsNullOrEmpty(userNameContains))
        {
            uri += $"?username={userNameContains}";
        }

        HttpResponseMessage response = await client.GetAsync(uri);
        string result = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(result);
        }

        IEnumerable<User> users = JsonSerializer.Deserialize<IEnumerable<User>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return users;
    }

    public async Task<User> GetUserByCprAsync(long cprNumber)
    {
        string uri = $"/Users/users?cpr={cprNumber}";
        HttpResponseMessage response = await client.GetAsync(uri);
        string result = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(result);
        }

        if (string.IsNullOrWhiteSpace(result))
        {
            throw new Exception("User not found or empty response from the API.");
        }

        User? user = JsonSerializer.Deserialize<User>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        });

        return user;
    }
}