﻿using Entity.Model;

namespace EfcDataAccess.DaoInterfaces;

public interface IUserDao
{
    Task<User?> CreateUserAsync(User? userEntity);
}