using System.Collections;
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

    public async Task<IEnumerable<Reservation>> GetReservationsAsync()
    {
        HttpResponseMessage response = await client.GetAsync("/reservations");
        string content = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(content);
        }

        IEnumerable<Reservation> reservations = JsonSerializer.Deserialize<IEnumerable<Reservation>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return reservations;
    }

    public async Task<Reservation> GetReservationById(int reservationId)
    {
        HttpResponseMessage response = await client.GetAsync($"/reservations/{reservationId}");
        string content = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(content);
        }

        GetReservationDto dto = JsonSerializer.Deserialize<GetReservationDto>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        Reservation reservation = new Reservation(dto.Id, dto.Username, dto.CarId, dto.StartDate, dto.EndDate, dto.TotalPrice);

        return reservation;
    }

    public async Task<IEnumerable<Reservation>> GetReservationsByCarId(int carId)
    {
        HttpResponseMessage response = await client.GetAsync($"/reservations/{carId}");
        string content = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(content);
        }
        
        IEnumerable<Reservation> reservations = JsonSerializer.Deserialize<IEnumerable<Reservation>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return reservations;
    }
}