using Domain.DTOs;
using Domain.Enums;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ICarService
{
    public Task<Car> CreateAsync(CarCreationDto carToCreate);
    public Task<IEnumerable<Car>> GetCarsAsync(string? brand, string? model, string? bodyType, int? horsePower, string? fuelType, string? gearbox, string? color, int? pricePerDay, CarStatus? status);
    public Task<Car> GetCarById(int carId);
    public Task UpdateAsync(CarCreationDto dto);
}