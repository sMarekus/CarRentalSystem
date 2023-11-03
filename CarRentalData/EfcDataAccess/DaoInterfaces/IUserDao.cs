using Entity.Model;

namespace EfcDataAccess.DaoInterfaces;

public interface IUserDao
{
    Task<UserEntity?> CreateUserAsync(UserEntity? userEntity);
}