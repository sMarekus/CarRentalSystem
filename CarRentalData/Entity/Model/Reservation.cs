using System.ComponentModel.DataAnnotations;

namespace Entity.Model;

public class Reservation
{
    [Key]
    public int Id { get; set; }
    public int CarId { get; set; }
    public int UserId { get; set; }
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    public double TotalPrice { get; set; }
}