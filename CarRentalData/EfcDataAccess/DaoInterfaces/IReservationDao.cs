using Entity.Model;

namespace EfcDataAccess.DaoInterfaces;

public interface IReservationDao
{
    Task<Reservation?> CreateReservationAsync(Reservation? reservationEntity);
    Task<IEnumerable<Reservation>> GetAllReservationsAsync();
}