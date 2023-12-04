namespace Domain.Models;

public class Reservation
{
    public int Id { get; set; }
    public int UserId{get;set;}
    public int CarId{get;set;}
    public DateTime StartDate{get;set;}
    public DateTime EndDate{get;set;}
    public int TotalPrice{get;set;}
    public Reservation(int id,int userId, int carId, DateTime startDate, DateTime endDate, int totalPrice)
    {
        Id = id;
        UserId = userId;
        CarId = carId;
        StartDate = startDate;
        EndDate = endDate;
        TotalPrice = totalPrice;
    }

}