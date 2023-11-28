using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using Domain.DTOs;
using Domain.Enums;
using Domain.Models;
using HttpClients.ClientInterfaces;
using HttpClients.utils;
using Microsoft.VisualBasic.CompilerServices;

namespace HttpClients.Implementations;

public class CarService : ICarService
{
    private readonly HttpClient client;

    public CarService(HttpClient client)
    {
        this.client = client;
        client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", UserService.Jwt);
    }

    public async Task<Car> CreateAsync(CarCreationDto carToCreate)
    {
        Console.WriteLine(UserService.Jwt);
        HttpResponseMessage response = await client.PostAsJsonAsync("/cars", carToCreate);
        string result = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(result);
        }

        Console.WriteLine(result);
        JsonSerializerOptions jsonOptions = new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
            PropertyNameCaseInsensitive = true,
            Converters = { new CustomEnumConverter<CarStatus>() }
        };
        Car car = JsonSerializer.Deserialize<Car>(result, jsonOptions)!;
        return car;
    }

    public async Task<IEnumerable<Car>> GetCarsAsync(string? brand, string? model, string? bodyType, int? horsePower,
        string? fuelType, string? gearbox, string? color, int? pricePerDay, CarStatus? status)
    {
        string query = ConstructQuery(brand, model, bodyType, horsePower, fuelType, gearbox, color, pricePerDay,
            status);

        HttpResponseMessage response = await client.GetAsync("/cars" + query);
        string content = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(content);
        }

        IEnumerable<Car> cars = JsonSerializer.Deserialize<IEnumerable<Car>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return cars;
    }

    private static string ConstructQuery(string? brand, string? model, string? bodyType, int? horsePower,
        string? fuelType, string? gearbox, string? color, int? pricePerDay, CarStatus? status)
    {
        string query = "";

        if (!string.IsNullOrEmpty(brand))
        {
            query += $"?brand={brand}";
        }

        if (!string.IsNullOrEmpty(model))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"model={model}";
        }

        if (!string.IsNullOrEmpty(bodyType))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"bodytype={bodyType}";
        }

        if (horsePower != null)
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"horsepower={horsePower}";
        }

        if (!string.IsNullOrEmpty(fuelType))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"fueltype={fuelType}";
        }

        if (!string.IsNullOrEmpty(gearbox))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"gearbox={gearbox}";
        }

        if (!string.IsNullOrEmpty(color))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"color={color}";
        }

        if (pricePerDay != null)
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"priceperday={pricePerDay}";
        }

        if (status != CarStatus.UNAVAILABLE)
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"status]{status}";
        }

        return query;
    }

    public async Task<Car> GetCarById(int carId)
    {
        HttpResponseMessage response = await client.GetAsync($"/cars/{carId}");
        string content = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(content);
        }

        CarCreationDto dto = JsonSerializer.Deserialize<CarCreationDto>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        Car car = new Car(dto.Brand, dto.Model, dto.BodyType, dto.HorsePower, dto.FuelType, dto.Gearbox, dto.Color,
            dto.Description,
            dto.PricePerDay, dto.Status);

        return car;
    }

    public async Task UpdateAsync(CarCreationDto dto)
    {
        string dtoAsJson = JsonSerializer.Serialize(dto);
        StringContent body = new StringContent(dtoAsJson, Encoding.UTF8, "application/json");

        HttpResponseMessage response = await client.PatchAsync("/cars", body);
        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            string content = await response.Content.ReadAsStringAsync();
            throw new Exception(content);
        }
    }
}