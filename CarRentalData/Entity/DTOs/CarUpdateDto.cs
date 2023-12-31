﻿using Entity.Enum;

namespace Entity.Model;

public class CarUpdateDto
{
    public int Id { get; init; }
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
    
    public override string ToString()
    {
        return $"Id: {Id}, Brand: {Brand}, Model: {Model}, BodyType: {BodyType}, HorsePower: {HorsePower}, FuelType: {FuelType}, Gearbox: {Gearbox}, Color: {Color}, Description: {Description}, PricePerDay: {PricePerDay}, Status: {Status}";
    }
    
    public CarUpdateDto(){}
}   