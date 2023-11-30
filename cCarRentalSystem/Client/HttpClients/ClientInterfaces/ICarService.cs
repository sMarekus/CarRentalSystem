using Domain.DTOs;
using Domain.Enums;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ICarService
{
    public Task<Car> CreateAsync(CarCreationDto carToCreate);
    public Task<IEnumerable<Car>> GetCarsAsync(string? brand = null, string? model= null, string? bodyType= null, int? horsePower= null, string? fuelType= null, string? gearbox= null, string? color= null, int? pricePerDay= null, CarStatus? status= null);
    public Task<Car> GetCarById(int carId);
    public Task UpdateAsync(CarCreationDto dto);
}