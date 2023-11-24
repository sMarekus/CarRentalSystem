using EfcDataAccess.DaoInterfaces;
using Entity.Model;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EfcDataAccess.DAOs;

public class CarDao : ICarDao
{
    private readonly CarRentalSystemContext context;
    
    public CarDao(CarRentalSystemContext context)
    {
        this.context = context;
    }
    
    public async Task<Car?> CreateCarAsync(Car? carEntity)
    {
        try
        {
            Console.WriteLine("DAO class received request");
            EntityEntry<Car>? carEntityEntry = await context.Cars.AddAsync(carEntity);
            await context.SaveChangesAsync();
            return carEntityEntry.Entity;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }
}