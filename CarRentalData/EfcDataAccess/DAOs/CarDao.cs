using EfcDataAccess.DaoInterfaces;
using Entity.Enum;
using Entity.Model;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EfcDataAccess.DAOs;

public class CarDao : ICarDao
{
    private readonly CarRentalSystemContext context;

    public CarDao(CarRentalSystemContext context)
    {
        this.context = context;
    }

    public async Task<Car?> CreateCarAsync(Car? carEntity)
    {
        try
        {
            Console.WriteLine("DAO class received request");
            EntityEntry<Car>? carEntityEntry = await context.Cars.AddAsync(carEntity);
            await context.SaveChangesAsync();
            return carEntityEntry.Entity;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }

    public async Task<IEnumerable<CarDto>> GetCarsAsync(CarFilterDto carFilterDto)
    {
        IQueryable<Car> query = context.Cars.AsQueryable();

        if (!string.IsNullOrEmpty(carFilterDto.Description))
        {
            carFilterDto.Description = carFilterDto.Description.Trim();
            query = query.Where(dto => dto.Description.Equals(carFilterDto.Description));
        }

        if (!string.IsNullOrEmpty(carFilterDto.Brand))
        {
            carFilterDto.Brand = carFilterDto.Brand.Trim();
            query = query.Where(dto => dto.Brand.Equals(carFilterDto.Brand));
        }

        if (!string.IsNullOrEmpty(carFilterDto.Model))
        {
            carFilterDto.Model = carFilterDto.Model.Trim();
            query = query.Where(dto => dto.Model.Equals(carFilterDto.Model));
        }

        if (!string.IsNullOrEmpty(carFilterDto.BodyType))
        {
            carFilterDto.BodyType = carFilterDto.BodyType.Trim();
            query = query.Where(dto => dto.BodyType.Equals(carFilterDto.BodyType));
        }

        if (carFilterDto.HorsePower is not null)
        {
            query = query.Where(dto => dto.HorsePower == carFilterDto.HorsePower);
        }

        if (!string.IsNullOrEmpty(carFilterDto.FuelType))
        {
            carFilterDto.FuelType = carFilterDto.FuelType.Trim();
            query = query.Where(dto => dto.FuelType.Equals(carFilterDto.FuelType));
        }

        if (!string.IsNullOrEmpty(carFilterDto.Gearbox))
        {
            carFilterDto.Gearbox = carFilterDto.Gearbox.Trim();
            query = query.Where(dto => dto.Gearbox.Equals(carFilterDto.Gearbox));
        }

        if (!string.IsNullOrEmpty(carFilterDto.Color))
        {
            carFilterDto.Color = carFilterDto.Color.Trim();
            query = query.Where(dto => dto.Color.Equals(carFilterDto.Color));
        }

        if (carFilterDto.PricePerDay is not null)
        {
            query = query.Where(dto => dto.PricePerDay == carFilterDto.PricePerDay);
        }

        List<Car> cars = await query.ToListAsync();
        IEnumerable<CarDto> carDtos = cars.Select(convertToCarDto);

        return carDtos;
    }

    public CarDto convertToCarDto(Car car)
    {
        CarDto carDto = new CarDto()
        {
            Brand = car.Brand,
            Model = car.Model,
            BodyType = car.BodyType,
            HorsePower = car.HorsePower,
            FuelType = car.FuelType,
            Gearbox = car.Gearbox,
            Color = car.Color,
            Description = car.Description,
            PricePerDay = car.PricePerDay,
            Status = CarStatus.AVAILABLE
        };
        return carDto;
    }
}