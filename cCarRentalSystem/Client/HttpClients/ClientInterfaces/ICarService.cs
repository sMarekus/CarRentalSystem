using Domain.DTOs;
using Domain.Enums;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ICarService
{
    public Task<Car> CreateAsync(CarCreationDto carToCreate);
    public Task<IEnumerable<Car>> GetCarsAsync(SearchCarParametersDto dto);
    public Task<Car> GetCarById(int carId);
    public Task UpdateAsync(CarUpdateDto dto);
    public Task DeleteAsync(int carId);
}