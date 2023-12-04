using System.Collections;
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

    public async Task<IEnumerable<Car>> GetCarsAsync(SearchCarParametersDto dto)
    {
        string query = ConstructQuery(dto);
        Console.WriteLine("Made query" +query);

        string endpoint = "/cars" + query;
        Console.WriteLine("Made endpoint " + endpoint);

        HttpResponseMessage response = await client.GetAsync(endpoint);
        string content = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            var statusCode = response.StatusCode;
            Console.WriteLine($"Status Code: {statusCode}");
            throw new Exception(content);
        }

        Console.WriteLine(content);
        JsonSerializerOptions jsonOptions = new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
            PropertyNameCaseInsensitive = true,
            Converters = { new CustomEnumConverter<CarStatus>() }
        };
        IEnumerable<Car> cars = JsonSerializer.Deserialize<IEnumerable<Car>>(content, jsonOptions)!;
        return cars;
    }

    private static string ConstructQuery(SearchCarParametersDto dto)
    {
        string query = "";

        if (!string.IsNullOrEmpty(dto.BrandContains))
        {
            query += $"?brand={dto.BrandContains}";
        }

        if (!string.IsNullOrEmpty(dto.ModelContains))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"model={dto.ModelContains}";
        }

        if (!string.IsNullOrEmpty(dto.BodyTypeContains))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"bodytype={dto.BodyTypeContains}";
        }

        if (dto.HorsePowerContains != null)
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"horsepower={dto.HorsePowerContains}";
        }

        if (!string.IsNullOrEmpty(dto.FuelTypeContains))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"fueltype={dto.FuelTypeContains}";
        }

        if (!string.IsNullOrEmpty(dto.GearboxContains))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"gearbox={dto.GearboxContains}";
        }

        if (!string.IsNullOrEmpty(dto.ColorContains))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"color={dto.ColorContains}";
        }

        if (dto.PricePerDayContains != null)
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"priceperday={dto.PricePerDayContains}";
        }

        if (dto.StatusContains != null)
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"status]{dto.StatusContains}";
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

        GetCarDto dto = JsonSerializer.Deserialize<GetCarDto>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        Car car = new Car(dto.Id,dto.Brand, dto.Model, dto.BodyType, dto.HorsePower, dto.FuelType, dto.Gearbox, dto.Color,
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