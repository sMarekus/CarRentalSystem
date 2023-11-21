using Entity.Model;

namespace EfcDataAccess.DaoInterfaces;

public interface IUserDao
{
    Task<User?> CreateUserAsync(User? userEntity);
    Task<User?> FetchUserByUsernameAsync(string username);
    Task<ICollection<User?>> FetchUsersAsync();
}