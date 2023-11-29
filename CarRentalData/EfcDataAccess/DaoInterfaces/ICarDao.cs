using Entity.Model;

namespace EfcDataAccess.DaoInterfaces;

public interface ICarDao
{
    Task<Car?> CreateCarAsync(Car? carEntity);
    Task<ICollection<CarDto>> GetCarsAsync(CarFilterDto fromProtoToCarFilterDto);
}