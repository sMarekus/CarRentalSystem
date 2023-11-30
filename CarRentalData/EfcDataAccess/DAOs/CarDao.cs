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
        /*
        IQueryable<Car> query = context.Cars.AsQueryable();

        if (!string.IsNullOrEmpty(carFilterDto.Description))
        {
            string description = carFilterDto.Description.Trim();
            query = query.Where(dto => dto.Description == description);
        }

        if (!string.IsNullOrEmpty(carFilterDto.Brand))
        {
            string brand = carFilterDto.Brand.Trim();
            query = query.Where(dto => dto.Brand == brand);
        }

        if (!string.IsNullOrEmpty(carFilterDto.Model))
        {
            string model = carFilterDto.Model.Trim();
            query = query.Where(dto => dto.Model == model);
        }

        if (!string.IsNullOrEmpty(carFilterDto.BodyType))
        {
            string bodyType = carFilterDto.BodyType.Trim();
            query = query.Where(dto => dto.BodyType == bodyType);
        }

        if (carFilterDto.HorsePower.HasValue)
        {
            query = query.Where(dto => dto.HorsePower == carFilterDto.HorsePower.Value);
        }

        if (!string.IsNullOrEmpty(carFilterDto.FuelType))
        {
            string fuelType = carFilterDto.FuelType.Trim();
            query = query.Where(dto => dto.FuelType == fuelType);
        }

        if (!string.IsNullOrEmpty(carFilterDto.Gearbox))
        {
            string gearBox = carFilterDto.Gearbox.Trim();
            query = query.Where(dto => dto.Gearbox == gearBox);
        }

        if (!string.IsNullOrEmpty(carFilterDto.Color))
        {
            string color = carFilterDto.Color.Trim();
            query = query.Where(dto => dto.Color == color);
        }

        if (carFilterDto.PricePerDay.HasValue)
        {
            query = query.Where(dto => dto.PricePerDay == carFilterDto.PricePerDay.Value);
        } */

        /* List<Car> cars = await query.ToListAsync(); */
        List<Car> cars = await context.Cars.ToListAsync();
        IEnumerable<CarDto> carDtos = cars.Select(convertToCarDto);

        return carDtos;
    }

    public CarDto convertToCarDto(Car car)
    {
        CarDto carDto = new CarDto()
        {
            Id = car.Id,
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