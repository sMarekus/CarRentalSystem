using CarRentalData;
using EfcDataAccess.DaoInterfaces;
using Entity.Model;
using Grpc.Core;

namespace GrpcService.Services;

public class CarService : CarProtoService.CarProtoServiceBase
{
    private readonly ICarDao carDao;
    
    public CarService(ICarDao carDao)
    {
        this.carDao = carDao;
    }
    
    public override async Task<CarProtoObj> CreateCar(CarProtoObj request, ServerCallContext context)
    {
        Console.WriteLine($"CreateCar called with request: {request}");
        
        try
        {
            Car? toAddCar = FromProtoToEntity(request);
            
            Console.WriteLine("Attempting to add car to database.");
            Car? addedCar = await carDao.CreateCarAsync(toAddCar);
            Console.WriteLine($"Car added to database: {addedCar}");
            
            CarProtoObj carProtoObj = FromEntityToProto(addedCar);
            return carProtoObj;
        }
        catch (Exception e)
        {
            Console.WriteLine($"Exception in CreateCar: {e.Message}");
            Console.WriteLine($"Stack Trace: {e.StackTrace}");
            throw new RpcException(new Status(StatusCode.AlreadyExists, e.Message));
        }
    }
    
    public static Car? FromProtoToEntity(CarProtoObj carProtoObj)
    {
        Console.WriteLine($"Converting Proto to Entity. Status: {carProtoObj.Status}");
        
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

        Console.WriteLine($"Converted Entity: {carEntity}");
        return carEntity;
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