using System.Net.Http.Json;
using System.Text.Json;
using Domain.Model;
using HTTPServices.Interfaces;

namespace HTTPServices.Implementations;

public class UserHttpClient:IUserService
{
    private readonly HttpClient client;

    public UserHttpClient(HttpClient client)
    {
        this.client = client;
    }

    public async Task<User> CreateUserAsync(User userToCreate)
    {
        HttpResponseMessage responseMessage = await client.PostAsJsonAsync("/users", userToCreate);
        string result = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        User user = JsonSerializer.Deserialize<User>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return user;
    }

}