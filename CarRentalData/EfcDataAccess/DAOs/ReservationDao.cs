using System.Collections;
using EfcDataAccess.DaoInterfaces;
using Entity.Enum;
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

    public async Task<Reservation> CancelReservationAsync(int reservationId)
    {
        Reservation reservation = await context.Reservations.FirstOrDefaultAsync(reservation => reservation.Id == reservationId);
        if(reservation == null)
        {
            throw new Exception("Reservation not found");
        }
        context.Reservations.Remove(reservation);
        await context.SaveChangesAsync();
        return reservation;
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

    public async Task<Reservation?> GetReservationByIdAsync(int reservationId)
    {
        try
        {
            Reservation? reservation =  await context.Reservations.FirstOrDefaultAsync(reservation => reservation.Id == reservationId);

            if (reservation == null)
            {
                throw new Exception("Reservation not found");
            }
       
            return await Task.FromResult(reservation);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }

    public async Task<IEnumerable<Reservation?>> GetReservationByUserNameAsync(string userName)
    {
        try
        {
            var reservations = await context.Reservations
                .Where(reservation => reservation.UserName == userName)
                .ToListAsync();

            return reservations;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }

    public async Task<IEnumerable<Reservation?>> GetReservationByCarIdAsync(int carId)
    {
        try
        {
            var reservations = await context.Reservations
                .Where(reservation => reservation.CarId == carId)
                .ToListAsync();

            return reservations;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }
}