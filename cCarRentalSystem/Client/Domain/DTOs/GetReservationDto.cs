namespace Domain.DTOs;

public class GetReservationDto
{
    public int Id{get;set;}
    public string Username{get;set;}
    public int CarId{get;set;}
    public DateTime StartDate{get;set;}
    public DateTime EndDate{get;set;}
    public int TotalPrice{get;set;}
    public bool IsCompleted { get; set; }

    public GetReservationDto(int id, string username, int carId, DateTime startDate, DateTime endDate, int totalPrice, bool isCompleted)
    {
        Id = id;
        Username = username;
        CarId = carId;
        StartDate = startDate;
        EndDate = endDate;
        TotalPrice = totalPrice;
        IsCompleted = isCompleted;
    }
}