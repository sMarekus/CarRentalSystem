using EfcDataAccess.DaoInterfaces;
using Entity.Model;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EfcDataAccess.DAOs;

public class UserDao : IUserDao
{
    private readonly CarRentalSystemContext context;
    
    public UserDao(CarRentalSystemContext context)
    {
        this.context = context;
    }
    
    public async Task<User?> CreateUserAsync(User? userEntity)
    {
        try
        {
            Console.WriteLine("DAO class received request");
            EntityEntry<User>? userEntityEntry = await context.Users.AddAsync(userEntity);
            await context.SaveChangesAsync();
            return userEntityEntry.Entity;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }
}