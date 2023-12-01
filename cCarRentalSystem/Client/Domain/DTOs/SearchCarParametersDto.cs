using System.Drawing;
using Domain.Enums;

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
    public CarStatus? StatusContains { get; }

    public SearchCarParametersDto(string? brandContains, string? modelContains, string? bodyTypeContains,
        int? horsePowerContains, string? fuelTypeContains, string? gearboxContains, string? colorContains,
        string? descriptionContains, int? pricePerDayContains, CarStatus? statusContains)
    {
        BrandContains = brandContains;
        ModelContains = modelContains;
        BodyTypeContains = bodyTypeContains;
        HorsePowerContains = horsePowerContains;
        FuelTypeContains = fuelTypeContains;
        GearboxContains = gearboxContains;
        ColorContains = colorContains;
        DescriptionContains = descriptionContains;
        PricePerDayContains = pricePerDayContains;
        StatusContains = statusContains;
    }
    
}