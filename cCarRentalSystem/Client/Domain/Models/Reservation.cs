namespace Domain.Models;

public class Reservation
{
    public int Id { get; set; }
    public string Username{get;set;}
    public int CarId{get;set;}
    public DateTime StartDate{get;set;}
    public DateTime EndDate{get;set;}
    public double TotalPrice{get;set;}
    public Reservation(string username, int carId, DateTime startDate, DateTime endDate, double totalPrice)
    {
        Username = username;
        CarId = carId;
        StartDate = startDate;
        EndDate = endDate;
        TotalPrice = totalPrice;
    }

}