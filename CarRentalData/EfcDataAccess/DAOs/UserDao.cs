using EfcDataAccess.DaoInterfaces;
using Entity.Model;
using Microsoft.EntityFrameworkCore;
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

    public async Task<ICollection<User?>> FetchUsersAsync()
    {
        if (!context.Users.Any()) throw new Exception("No users found");
        ICollection<User?> users = await context.Users.AsNoTracking().ToListAsync();
        return users;
    }
    
    public async Task<User?> FetchUserByCprAsync(long cpr)
    {
        User? user = await context.Users.AsNoTracking().FirstOrDefaultAsync(u => u.CprNumber == cpr);

        if (user == null)
        {
            throw new Exception("User not found");
        }
        
        return user;
    }
}