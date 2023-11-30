using Entity.Model;

namespace EfcDataAccess.DaoInterfaces;

public interface ICarDao
{
    Task<Car?> CreateCarAsync(Car? carEntity);
    Task<IEnumerable<CarDto>> GetCarsAsync(CarFilterDto fromProtoToCarFilterDto);
}