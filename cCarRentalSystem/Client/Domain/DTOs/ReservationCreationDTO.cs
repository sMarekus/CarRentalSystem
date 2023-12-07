using Domain.Models;

namespace Domain.DTOs;

public class ReservationCreationDTO
{
    public string UserName{get;set;}
    public int CarId{get;set;}
    public DateTime StartDate{get;set;}
    public DateTime EndDate{get;set;}
    public int TotalPrice{get;set;}

    public ReservationCreationDTO(int carId, string username, DateTime startDate, DateTime endDate, int totalPrice)
    {
        CarId = carId;
        UserName = username;
        StartDate = startDate;
        EndDate = endDate;
        TotalPrice = totalPrice;
    }
}