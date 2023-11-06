using Domain.Enums;

namespace Domain.DTOs;

public class CarCreationDto
{
    public string Brand { get; }
    public string Model { get; }
    public string BodyType { get; }
    public int HorsePower { get; }
    public string FuelType { get; }
    public string Gearbox { get; }
    public string Color { get; }
    public string Description { get; }
    public int PricePerDay { get; }
    public CarStatus Status { get; }

    public CarCreationDto(string brand, string model, string bodyType, int horsePower, string fuelType, string gearbox,
        string color, string description, int pricePerDay, CarStatus status)
    {
        Brand = brand;
        Model = model;
        BodyType = bodyType;
        HorsePower = horsePower;
        FuelType = fuelType;
        Gearbox = gearbox;
        Color = color;
        Description = description;
        PricePerDay = pricePerDay;
        Status = status;
    }
}