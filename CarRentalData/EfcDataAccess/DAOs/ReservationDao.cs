using System.Collections;
using EfcDataAccess.DaoInterfaces;
using Entity.Model;
using Microsoft.EntityFrameworkCore;
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

    public async Task<IEnumerable<Reservation>> GetAllReservationsAsync()
    {
        try
        {
            List<Reservation> reservations = await context.Reservations.ToListAsync();
            return reservations;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }
}