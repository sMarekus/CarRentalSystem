using Entity.Enum;

namespace Entity.Model;

public class CarFilterDto
{
    public string? Brand { get; set; }
    public string? Model { get; set;}
    public string? BodyType {get; set;}
    public int? HorsePower {get; set;}
    public string? FuelType {get; set;}
    public string? Gearbox{get; set;}
    public string? Color {get; set;}
    public string? Description {get; set;}
    public int? PricePerDay {get; set;}
    public CarStatus? Status {get; set;}


    public override string ToString()
    {
        return $"Brand: {Brand}, Model: {Model}, BodyType: {BodyType}, HorsePower: {HorsePower}, FuelType: {FuelType}, Gearbox: {Gearbox}, Color: {Color}, Description: {Description}, PricePerDay: {PricePerDay}, Status: {Status}";
    }
}