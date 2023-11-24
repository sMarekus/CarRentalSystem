using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Security.Claims;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class UserService : IUserService
{

    private readonly HttpClient client;
    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; } = null!;
    public static string? Jwt { get; private set; } = "";

    public UserService(HttpClient client)
    {
        this.client = client;
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Jwt);
    }
    
    public async Task<User> CreateAsync(UserCreationDto userToCreate)
    {
        Console.WriteLine($"{userToCreate.UserName}, {userToCreate.Password}, {userToCreate.FirstName}, {userToCreate.LastName}, {userToCreate.Email}, {userToCreate.PhoneNumber}, {userToCreate.IsAdmin}");
        HttpResponseMessage response = await client.PostAsJsonAsync("/users", userToCreate);
        Console.WriteLine("Response received");
        string result = await response.Content.ReadAsStringAsync();
        Console.WriteLine("Response read");
        
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
        Console.WriteLine("User deserialized");

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
        HttpResponseMessage responseMessage = await client.GetAsync("/users");
        string result = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        IEnumerable<User?> userEntities = JsonSerializer.Deserialize<IEnumerable<User>>(result,
            new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            })!;

        return userEntities.ToList();
    }

    public async Task<User> GetUserByUserNameAsync(string username)
    {
        HttpResponseMessage responseMessage = await client.GetAsync($"/users/{username}");
        string result = await responseMessage.Content.ReadAsStringAsync();

        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        User userEntity = JsonSerializer.Deserialize<User>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return userEntity;
    }

    public async Task<AuthenticationResponse> ValidateUser(string username, string password)
    {
        UserLoginDto loginDto = new UserLoginDto
        {
            Username = username,
            Password = password
        };

        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/users/authenticate", loginDto);
        string result = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        AuthenticationResponse authenticationResponse = JsonSerializer.Deserialize<AuthenticationResponse>(result,
            new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            })!;

        Jwt = authenticationResponse.token;
        ClaimsPrincipal principal = CreateClaimsPrincipal();
        OnAuthStateChanged.Invoke(principal);
        return authenticationResponse;
    }

    private ClaimsPrincipal CreateClaimsPrincipal()
    {
        if (string.IsNullOrEmpty(Jwt))
        {
            return new ClaimsPrincipal();
        }

        IEnumerable<Claim> claimsFromJwt = ParseClaimsFromJwt(Jwt);

        ClaimsIdentity identity = new ClaimsIdentity(claimsFromJwt, "jwt");

        ClaimsPrincipal principal = new(identity);
        return principal;
    }

    public Task<ClaimsPrincipal> GetAuthAsync()
    {
        ClaimsPrincipal principal = CreateClaimsPrincipal();
        return Task.FromResult(principal);
    }

    private static IEnumerable<Claim> ParseClaimsFromJwt(string jwt)
    {
        string payload = jwt.Split('.')[1];
        byte[] jsonBytes = ParseBase64WithoutPadding(payload);
        Dictionary<string, object>? keyValuePairs = JsonSerializer.Deserialize<Dictionary<string, object>>(jsonBytes);
        return keyValuePairs!.Select(kvp => new Claim(kvp.Key, kvp.Value.ToString()!));
    }

    private static byte[] ParseBase64WithoutPadding(string base64)
    {
        switch (base64.Length % 4)
        {
            case 2:
                base64 += "==";
                break;
            case 3:
                base64 += "=";
                break;
        }

        return Convert.FromBase64String(base64);
    }
}