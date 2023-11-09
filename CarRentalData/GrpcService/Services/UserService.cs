using EfcDataAccess.DaoInterfaces;

namespace GrpcService.Services;
using Grpc.Core;
using Entity.Model;
using Google.Protobuf.Collections;
using Google.Protobuf.WellKnownTypes;
using CarRentalData;

public class UserService : UserProtoService.UserProtoServiceBase
{
    private readonly IUserDao userDao;
    
    public UserService(IUserDao userDao)
    {
        this.userDao = userDao;
    }

    public override async Task<UserProtoObj> CreateUser(UserProtoObj request, ServerCallContext context)
    {
        try
        {   Console.WriteLine("Service class received request");
            User? toAddUser = FromProtoToEntity(request);
            User? addedUser = await userDao.CreateUserAsync(toAddUser);

            UserProtoObj userProtoObj = FromEntityToProto(addedUser);
            return userProtoObj;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw new RpcException(new Status(StatusCode.AlreadyExists, e.Message));
        }
    }

    public static User? FromProtoToEntity(UserProtoObj userProtoObj)
    {
        User? userEntity = new User()
        {
            Cpr = userProtoObj.CprNumber,
            FirstName = userProtoObj.FirstName,
            LastName = userProtoObj.LastName,
            Email = userProtoObj.Email,
            Password = userProtoObj.Password,
            PhoneNumber = userProtoObj.PhoneNumber,
            IsAdmin = userProtoObj.IsAdmin
        };

        return userEntity;
    }
    
    public static UserProtoObj FromEntityToProto(User? userEntity)
    {
        UserProtoObj userProtoObj = new UserProtoObj()
        {
            CprNumber = userEntity.Cpr,
            FirstName = userEntity.FirstName,
            LastName = userEntity.LastName,
            Email = userEntity.Email,
            Password = userEntity.Password,
            PhoneNumber = userEntity.PhoneNumber,
            IsAdmin = userEntity.IsAdmin
        };

        return userProtoObj;
    }
}