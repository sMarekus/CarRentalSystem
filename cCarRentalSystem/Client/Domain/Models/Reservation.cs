namespace Domain.Models;

public class Reservation
{
    public int Id { get; set; }
    public int UserId{get;set;}
    public int CarId{get;set;}
    public DateTime StartDate{get;set;}
    public DateTime EndDate{get;set;}
    public double TotalPrice{get;set;}
    public Reservation(int userId, int carId, DateTime startDate, DateTime endDate, double totalPrice)
    {
        UserId = userId;
        CarId = carId;
        StartDate = startDate;
        EndDate = endDate;
        TotalPrice = totalPrice;
    }

}