using Domain.Models;

namespace Domain.DTOs;

public class ReservationCreationDTO
{
    public int Id{get;set;}
    public int UserId{get;set;}
    public int CarId{get;set;}
    public DateTime StartDate{get;set;}
    public DateTime EndDate{get;set;}
    public int TotalPrice{get;set;}

    public ReservationCreationDTO(int userId, int carId, DateTime startDate, DateTime endDate, int totalPrice)
    {
        UserId = userId;
        CarId = carId;
        StartDate = startDate;
        EndDate = endDate;
        TotalPrice = totalPrice;
    }
}