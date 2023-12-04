using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IReservationService
{
    Task<Reservation> CreateAsync(ReservationCreationDTO reservationToCreate);
    Task<IEnumerable<Reservation>> GetReservationsAsync();
    Task<Reservation> GetReservationById(int reservationId);
}