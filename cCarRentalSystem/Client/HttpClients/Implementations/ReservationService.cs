using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class ReservationService: IReservationService
{
    private HttpClient client;
    public ReservationService(HttpClient client)
    {
        this.client = client;
        this.client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", UserService.Jwt);
    }

    public async Task<Reservation> CreateAsync(ReservationCreationDTO reservationToCreate)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/reservations", reservationToCreate);
        string result = await response.Content.ReadAsStringAsync();
        if(!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(result);
        }
        Reservation reservation = JsonSerializer.Deserialize<Reservation>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return reservation;
    }

    public Task<IEnumerable<Reservation>> GetReservationsAsync()
    {
        throw new NotImplementedException();
    }

    public Task<Reservation> GetReservationById(int reservationId)
    {
        throw new NotImplementedException();
    }
}