using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Entity.Enum;

namespace Entity.Model;

public class Car
{
    [Key]
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
}