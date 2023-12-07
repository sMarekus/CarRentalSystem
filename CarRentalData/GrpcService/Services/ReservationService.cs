﻿using CarRentalData;
using EfcDataAccess.DaoInterfaces;
using Entity.Model;
using Google.Protobuf.Collections;
using Google.Protobuf.WellKnownTypes;
using Grpc.Core;

namespace GrpcService.Services;

public class ReservationService : ReservationProtoService.ReservationProtoServiceBase
{
    private readonly IReservationDao reservationDao;
    
    public ReservationService(IReservationDao reservationDao)
    {
        this.reservationDao = reservationDao;
    }
    
    public override async Task<ReservationProtoObj> CreateReservation(ReservationProtoObj request, ServerCallContext context)
    {
        try
        {
            Reservation? toAddReservation = FromProtoToEntity(request);
            
            Reservation? addedReservation = await reservationDao.CreateReservationAsync(toAddReservation);
            
            ReservationProtoObj reservationProtoObj = FromEntityToProto(addedReservation);
            return reservationProtoObj;
        }
        catch (Exception e)
        {
            throw new RpcException(new Status(StatusCode.AlreadyExists, e.Message));
        }
    }

    public override async Task<ReservationProtoList> GetAllReservations(Empty request, ServerCallContext context)
    {
        try
        {
            IEnumerable<Reservation> reservations = await reservationDao.GetAllReservationsAsync();
            List<ReservationProtoObj> protoObjs = reservations.Select(FromEntityToProto).ToList();
            
            return new ReservationProtoList()
            {
                Reservation = { protoObjs }
            };
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }

    public static Reservation? FromProtoToEntity(ReservationProtoObj reservationProtoObj)
    {
        Reservation? reservationEntity = new Reservation()
        {   
            Id = reservationProtoObj.Id,
            CarId = reservationProtoObj.CarId,
            UserName = reservationProtoObj.UserName,
            StartDate = reservationProtoObj.StartDate.ToDateTime(),
            EndDate = reservationProtoObj.EndDate.ToDateTime(),
            TotalPrice = reservationProtoObj.TotalPrice,
        };
        
        return reservationEntity;
    }
    
    public static ReservationProtoObj FromEntityToProto(Reservation? reservationEntity)
    {
        ReservationProtoObj reservationProtoObj = new ReservationProtoObj()
        {   
            Id = reservationEntity.Id,
            CarId = reservationEntity.CarId,
            UserName = reservationEntity.UserName,
            StartDate = Timestamp.FromDateTime(reservationEntity.StartDate.ToUniversalTime()),
            EndDate = Timestamp.FromDateTime(reservationEntity.EndDate.ToUniversalTime()),
            TotalPrice = reservationEntity.TotalPrice,
        };

        return reservationProtoObj;
    }
}