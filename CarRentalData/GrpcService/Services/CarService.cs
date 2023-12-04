using CarRentalData;
using EfcDataAccess.DaoInterfaces;
using Entity.Model;
using Google.Protobuf.Collections;
using Google.Protobuf.WellKnownTypes;
using Grpc.Core;

namespace GrpcService.Services;

public class CarService : CarProtoService.CarProtoServiceBase
{
    private readonly ICarDao carDao;
    
    public CarService(ICarDao carDao)
    {
        this.carDao = carDao;
    }

    public override async Task<ListCarObj> GetCars(CarFilterProtoObj request, ServerCallContext context)
    {
        try
        {
            IEnumerable<CarDto> cars = await carDao.GetCarsAsync(FromProtoToCarFilterDto(request));
            RepeatedField<CarFilterProtoObj> carProtoObjs = new RepeatedField<CarFilterProtoObj>();

            List<CarProtoObj> protoObjs = cars.Select(FromDtoToProto).ToList();

            return new ListCarObj()
            {
                CarList = { protoObjs }
            };
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw new RpcException(new Status(StatusCode.NotFound, e.Message));
        }
    }
    public override async Task<CarProtoObj> GetCarById(Int32Value request, ServerCallContext context)
    {
        try
        {
            Car car = await carDao.GetCarByIdAsync(request.Value );
            CarDto dto = new CarDto(car.Id, car.Brand, car.Model, car.BodyType, car.HorsePower, car.FuelType,
                car.Gearbox, car.Color, car.Description, car.PricePerDay, car.Status);
            CarProtoObj carProtoObj = convertDtoToProto(dto);
            return carProtoObj;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw new RpcException(new Status(StatusCode.NotFound, e.Message));
        }
    }

    private CarProtoObj convertDtoToProto(CarDto carDto)
    {
        CarProtoObj carProtoObj = new CarProtoObj()
        {
            Id = carDto.Id,
            Brand = carDto.Brand,
            Model = carDto.Model,
            BodyType = carDto.BodyType,
            HorsePower = carDto.HorsePower,
            FuelType = carDto.FuelType,
            Gearbox = carDto.Gearbox,
            Color = carDto.Color,
            Description = carDto.Description,
            PricePerDay = carDto.PricePerDay,
            Status = ConvertStatus(carDto.Status),
        };
        return carProtoObj;
    }

    public override async Task<CarProtoObj> CreateCar(CarProtoObj request, ServerCallContext context)
    {
        try
        {
            Car? toAddCar = FromProtoToEntity(request);
            
            Car? addedCar = await carDao.CreateCarAsync(toAddCar);
            
            CarProtoObj carProtoObj = FromEntityToProto(addedCar);
            return carProtoObj;
        }
        catch (Exception e)
        {
            throw new RpcException(new Status(StatusCode.AlreadyExists, e.Message));
        }
    }



    public static Car? FromProtoToEntity(CarProtoObj carProtoObj)
    {
        Car? carEntity = new Car()
        {
            Id = carProtoObj.Id,
            Brand = carProtoObj.Brand,
            Model = carProtoObj.Model,
            BodyType = carProtoObj.BodyType,
            HorsePower = carProtoObj.HorsePower,
            FuelType = carProtoObj.FuelType,
            Gearbox = carProtoObj.Gearbox,
            Color = carProtoObj.Color,
            Description = carProtoObj.Description,
            PricePerDay = carProtoObj.PricePerDay,
            Status = ConvertProtoStatusToEntityStatus(carProtoObj.Status),
        };
        
        return carEntity;
    }

    public static CarFilterDto FromProtoToCarFilterDto(CarFilterProtoObj carFilterProtoObj)
    {
        CarFilterDto carDto = new CarFilterDto()
        {
            Id = carFilterProtoObj.Id,
            Brand = carFilterProtoObj.Brand,
            Model = carFilterProtoObj.Model,
            BodyType = carFilterProtoObj.BodyType,
            HorsePower = carFilterProtoObj.HorsePower,
            FuelType = carFilterProtoObj.FuelType,
            Gearbox = carFilterProtoObj.Gearbox,
            Color = carFilterProtoObj.Color,
            Description = carFilterProtoObj.Description,
            PricePerDay = carFilterProtoObj.PricePerDay,
            Status = ConvertProtoStatusToEntityStatus(carFilterProtoObj.Status),
        };
        
        return carDto;
    }
    
    public static CarProtoObj FromEntityToProto(Car? carEntity)
    {
        CarProtoObj carProtoObj = new CarProtoObj()
        {
            Id = carEntity.Id,
            Brand = carEntity.Brand,
            Model = carEntity.Model,
            BodyType = carEntity.BodyType,
            HorsePower = carEntity.HorsePower,
            FuelType = carEntity.FuelType,
            Gearbox = carEntity.Gearbox,
            Color = carEntity.Color,
            Description = carEntity.Description,
            PricePerDay = carEntity.PricePerDay,
            Status = CarStatus.Available
        };

        return carProtoObj;
    }

    public static CarProtoObj FromDtoToProto(CarDto carEntity)
    {
        CarProtoObj carProtoObj = new CarProtoObj()
        {
            Id = carEntity.Id,
            Brand = carEntity.Brand,
            Model = carEntity.Model,
            BodyType = carEntity.BodyType,
            HorsePower = carEntity.HorsePower,
            FuelType = carEntity.FuelType,
            Gearbox = carEntity.Gearbox,
            Color = carEntity.Color,
            Description = carEntity.Description,
            PricePerDay = carEntity.PricePerDay,
            Status = ConvertStatus(carEntity.Status),
        };

        return carProtoObj;
    }
    private static CarStatus ConvertStatus(Entity.Enum.CarStatus status)
    {
        switch (status)
        {
            case Entity.Enum.CarStatus.AVAILABLE:
                return CarRentalData.CarStatus.Available;
            case Entity.Enum.CarStatus.RESERVED:
                return CarRentalData.CarStatus.Reserved;
            case Entity.Enum.CarStatus.UNAVAILABLE:
                return CarRentalData.CarStatus.Unavailable;
            default:
                throw new ArgumentOutOfRangeException(nameof(status), status, null);
        }
    }
    
    private static Entity.Enum.CarStatus ConvertProtoStatusToEntityStatus(CarRentalData.CarStatus protoStatus)
    {
        switch (protoStatus)
        {
            case CarRentalData.CarStatus.Available:
                return Entity.Enum.CarStatus.AVAILABLE;
            case CarRentalData.CarStatus.Reserved:
                return Entity.Enum.CarStatus.RESERVED;
            case CarRentalData.CarStatus.Unavailable:
                return Entity.Enum.CarStatus.UNAVAILABLE;
            default:
                throw new ArgumentOutOfRangeException(nameof(protoStatus), protoStatus, null);
        }
    }
}