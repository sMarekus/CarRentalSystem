using Domain.Models;

namespace Domain.DTOs;

public class ReservationCreationDTO
{
    public int Id{get;set;}
    public string Username{get;set;}
    public int CarId{get;set;}
    public DateTime StartDate{get;set;}
    public DateTime EndDate{get;set;}
    public int TotalPrice{get;set;}

    public ReservationCreationDTO(string username, int carId, DateTime startDate, DateTime endDate, int totalPrice)
    {
        Username = username;
        CarId = carId;
        StartDate = startDate;
        EndDate = endDate;
        TotalPrice = totalPrice;
    }
}