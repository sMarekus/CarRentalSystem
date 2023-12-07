using EfcDataAccess.DaoInterfaces;
using Entity.Model;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EfcDataAccess.DAOs;

public class ReservationDao : IReservationDao
{
    private readonly CarRentalSystemContext context;

    public ReservationDao(CarRentalSystemContext context)
    {
        this.context = context;
    }
    
    public async Task<Reservation?> CreateReservationAsync(Reservation? reservationEntity)
    {
        try
        {
            Console.WriteLine("DAO class received request");
            EntityEntry<Reservation>? reservationEntityEntry = await context.Reservations.AddAsync(reservationEntity);
            await context.SaveChangesAsync();
            return reservationEntityEntry.Entity;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }
}