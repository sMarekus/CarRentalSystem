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
            EntityEntry<User>? userEntityEntry = await context.Users.AddAsync(userEntity);
            await context.SaveChangesAsync();
            return userEntityEntry.Entity;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }

    public async Task<User?> UpdateUserAsync(User userEntity)
    {
        context.Users.Update(userEntity);
        await context.SaveChangesAsync();
        return userEntity;
    }

    public async Task<ICollection<User?>> FetchUsersAsync()
    {
        if (!context.Users.Any()) throw new Exception("No users found");
        ICollection<User?> users = await context.Users.AsNoTracking().ToListAsync();
        return users;
    }
    
    public async Task<User?> FetchUserByUsernameAsync(string username)
    {
        User? user = await context.Users.AsNoTracking().FirstOrDefaultAsync(u => u.Username.ToLower().Equals(username.ToLower()));

        if (user == null)
        {
            throw new Exception("Username does not exists");
        }
        
        return user;
    }
}