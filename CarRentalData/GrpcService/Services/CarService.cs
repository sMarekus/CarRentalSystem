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
        try
        {
            Car? toAddCar = FromProtoToEntity(request);
            Car? addedCar = await carDao.CreateCarAsync(toAddCar);
            
            CarProtoObj carProtoObj = FromEntityToProto(addedCar);
            return carProtoObj;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
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
        return (CarStatus)Enum.Parse(typeof(CarStatus), status.ToString());
    }
    
    private static Entity.Enum.CarStatus ConvertProtoStatusToEntityStatus(CarRentalData.CarStatus protoStatus)
    {
        // Assuming both enums have the same names for their members
        return (Entity.Enum.CarStatus)Enum.Parse(typeof(Entity.Enum.CarStatus), protoStatus.ToString());
    }
}