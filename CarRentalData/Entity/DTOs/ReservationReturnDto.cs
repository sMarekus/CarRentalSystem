namespace Entity.Model;

public class ReservationReturnDto
{
    public int id { get; set; }
    public int? carId { get; set; }
    public string? userName { get; set; }
    public DateTime? startDate { get; set; }
    public DateTime? endDate { get; set; }
    public double? totalPrice { get; set; }
    public bool? isCompleted { get; set; }
    
    public override string ToString()
    {
        return $"Id: {id}, CarId: {carId}, UserName: {userName}, StartDate: {startDate}, EndDate: {endDate}, TotalPrice: {totalPrice}, IsCompleted: {isCompleted}";
    }
    
    public ReservationReturnDto(){}
    
    public ReservationReturnDto(int id)
    {
        this.id = id;
    }
}