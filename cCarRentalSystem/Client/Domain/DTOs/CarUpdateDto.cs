using Domain.Enums;

namespace Domain.DTOs;

public class CarUpdateDto
{
    public int Id { get; }
    public string? Brand { get; set; }
    public string? Model { get; set; }
    public string? BodyType { get; set; }
    public int? HorsePower { get; set;}
    public string? FuelType { get; set; }
    public string? Gearbox { get; set; }
    public string? Color { get; set; }
    public string? Description { get; set; }
    public int? PricePerDay { get; set; }
    public CarStatus Status { get; set; }

    public CarUpdateDto(int id)  // Id is required
    {
        Id = id;
    }
    
    public CarUpdateDto(){}
}