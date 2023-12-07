namespace Domain.Models;

public class Reservation
{
    public int Id { get; set; }
    public string UserName{get;set;}
    public int CarId{get;set;}
    public DateTime StartDate{get;set;}
    public DateTime EndDate{get;set;}
    public double TotalPrice{get;set;}
    public Reservation(int carId, string username, DateTime startDate, DateTime endDate, double totalPrice)
    {
        CarId = carId;
        UserName = username;
        StartDate = startDate;
        EndDate = endDate;
        TotalPrice = totalPrice;
    }

}