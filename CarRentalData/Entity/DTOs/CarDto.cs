using System.ComponentModel.DataAnnotations.Schema;
using Entity.Enum;

namespace Entity.Model;

public class CarDto
{
    
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public int Id { get; set; }
    public string Brand { get; set; }
    public string Model { get; set; }
    public string BodyType { get; set; }
    public int HorsePower { get; set; }
    public string FuelType { get; set; }
    public string Gearbox { get; set; }
    public string Color { get; set; }
    public string Description { get; set; }
    public int PricePerDay { get; set; }
    public CarStatus Status { get; set; }
    
    public CarDto (int id,string brand, string model, string bodyType, int horsePower, string fuelType, string gearbox,
        string color, string description, int pricePerDay, CarStatus status)
    {
        Id = id;
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
    public CarDto()
    {
        
    }
}