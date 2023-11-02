namespace Domain.Model;

public class Car
{
    private string Make { get; }
    private string Model { get; }
    private string Color { get; }
    private string BodyType { get; }
    private string FuelType { get; }
    private string Description { get; }
    private string GearBox { get; }
    private int HorsePower { get; }
    private double PricePerDay { get; }

    public Car(string make,string model,string color,string bodyType,string fuelType,string description,string gearBox,int horsePower,double pricePerDay )
    {
        Make = make;
        Model = model;
        Color = color;
        BodyType = bodyType;
        FuelType = fuelType;
        Description = description;
        GearBox = gearBox;
        HorsePower = horsePower;
        PricePerDay = pricePerDay;
    }


}