using Entity.Model;

namespace EfcDataAccess.DaoInterfaces;

public interface IReservationDao
{
    Task<Reservation?> CreateReservationAsync(Reservation? reservationEntity);
    Task<IEnumerable<Reservation>> GetAllReservationsAsync();
    Task<Reservation?> GetReservationByIdAsync(int reservationId);
    Task<IEnumerable<Reservation?>> GetReservationByUserNameAsync(string userName);
    Task<IEnumerable<Reservation?>> GetReservationByCarIdAsync(int carId);
}