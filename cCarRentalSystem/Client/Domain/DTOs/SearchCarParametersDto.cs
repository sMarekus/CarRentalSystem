namespace Domain.DTOs;

public class SearchCarParametersDto
{
    public string? BrandContains { get; }
    public string? ModelContains { get; }
    public string? BodyTypeContains { get; }
    public int? HorsePowerContains { get; }
    public string? FuelTypeContains { get; }
    public string? GearboxContains { get; }
    public string? ColorContains { get; }
    public string? DescriptionContains { get; }
    public int? PricePerDayContains { get; }
    
}