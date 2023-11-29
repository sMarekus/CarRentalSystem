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

    public async Task<ICollection<CarDto>> GetCarsAsync(CarFilterDto carFilterDto)
    {
        Console.WriteLine("Car filter =====================>" + carFilterDto);
        carFilterDto.Description = carFilterDto.Description.Trim();
        carFilterDto.Brand = carFilterDto.Brand.Trim();
        carFilterDto.Model = carFilterDto.Model.Trim();
        carFilterDto.BodyType = carFilterDto.BodyType.Trim();
        carFilterDto.FuelType = carFilterDto.FuelType.Trim();
        carFilterDto.Gearbox = carFilterDto.Gearbox.Trim();
        carFilterDto.Color = carFilterDto.Color.Trim();

        Console.WriteLine(carFilterDto.Description is null);
        var queryAble = context.Cars.AsQueryable();

        if (string.IsNullOrEmpty(carFilterDto.Description))
        {
            Console.WriteLine(carFilterDto.Description);
            queryAble = queryAble.Where(dto => dto.Description.Equals(carFilterDto.Description));
        }

        if (string.IsNullOrEmpty(carFilterDto.Brand))
        {
            Console.WriteLine(carFilterDto.Brand);

            queryAble = queryAble.Where(dto => dto.Brand.Equals(carFilterDto.Brand));
        }

        if (string.IsNullOrEmpty(carFilterDto.Model))
        {
            Console.WriteLine(carFilterDto.Model);

            queryAble = queryAble.Where(dto => dto.Model.Equals(carFilterDto.Model));
        }

        if (string.IsNullOrEmpty(carFilterDto.BodyType))
        {
            Console.WriteLine(carFilterDto.BodyType);

            queryAble = queryAble.Where(dto => dto.BodyType.Equals(carFilterDto.BodyType));
        }

        if (carFilterDto.HorsePower is not null)
        {
            Console.WriteLine(carFilterDto.HorsePower);

            queryAble = queryAble.Where(dto => dto.HorsePower == carFilterDto.HorsePower);
        }

        if (string.IsNullOrEmpty(carFilterDto.FuelType))
        {
            Console.WriteLine(carFilterDto.FuelType);
            queryAble = queryAble.Where(dto => dto.FuelType.Equals(carFilterDto.FuelType));
        }

        if (string.IsNullOrEmpty(carFilterDto.Gearbox))
        {
            Console.WriteLine(carFilterDto.Gearbox);
            queryAble = queryAble.Where(dto => dto.Gearbox.Equals(carFilterDto.Gearbox));
        }

        if (string.IsNullOrEmpty(carFilterDto.Color))
        {
            Console.WriteLine(carFilterDto.Color);
            queryAble = queryAble.Where(dto => dto.Color.Equals(carFilterDto.Color));
        }

        if (carFilterDto.PricePerDay is not null)
        {
            Console.WriteLine(carFilterDto.PricePerDay);
            queryAble = queryAble.Where(dto => dto.PricePerDay == carFilterDto.PricePerDay);
        }



        List<Car> cars = await queryAble.ToListAsync();

        Console.WriteLine("Car count =========================>  " + cars.Count);
        ICollection<CarDto> carDtos = cars.Select(convertToCarDto).ToList();

        Console.WriteLine("Car count =========================>  " + carDtos.Count);


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