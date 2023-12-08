package com.example.carrentalservice.GrpcClient.Reservation;

import com.example.carrentalservice.GrpcClient.ManagedChannelProvider;
import com.example.carrentalservice.model.Reservation;
import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import com.google.protobuf.Timestamp;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;
import proto.ReservationProtoServiceGrpc;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationClientImpl implements IReservationClient
{
    private ReservationProtoServiceGrpc.ReservationProtoServiceBlockingStub reservationStub;

    public ReservationProtoServiceGrpc.ReservationProtoServiceBlockingStub getStub() {
        if (reservationStub == null) {
            ManagedChannel channel = ManagedChannelProvider.getChannel();
            reservationStub = ReservationProtoServiceGrpc.newBlockingStub(channel);
        }
        return reservationStub;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        System.out.println("Hit");
        try {
            proto.Reservation.ReservationProtoObj reservationProtoObj = fromEntityToProtoObj(reservation);
            proto.Reservation.ReservationProtoObj protoObjFromServer = getStub().createReservation(reservationProtoObj);
            return fromProtoObjToEntity(protoObjFromServer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reservation returnReservation(int id) {
        try {
            proto.Reservation.ReservationProtoObj reservationProtoObj = getStub().returnReservation(Int32Value.of(id));
            proto.Reservation.ReservationProtoObj protoObjFromServer = getStub().returnReservation(Int32Value.of(id));
            return fromProtoObjToEntity(protoObjFromServer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reservation> getReservations() {
        try {
            proto.Reservation.ReservationProtoList reservationProtoObjs = getStub().getAllReservations(Empty.newBuilder().build());
            List<Reservation> reservations=new ArrayList<>();
            for (proto.Reservation.ReservationProtoObj reservationProtoObj : reservationProtoObjs.getReservationList()) {
                Reservation reservation=(fromProtoObjToEntity(reservationProtoObj));
                reservations.add(reservation);
            }
            return reservations;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reservation getReservationById(int id) {
        try {
            proto.Reservation.ReservationProtoObj reservationProtoObj = getStub().getReservationById(Int32Value.of(id));
            return fromProtoObjToEntity(reservationProtoObj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reservation> getReservationsByCarId(int carId) {
        try {
            proto.Reservation.ReservationProtoList reservationProtoObjs = getStub().getReservationsByCarId(Int32Value.of(carId));
            List<Reservation> reservations=new ArrayList<>();
            for (proto.Reservation.ReservationProtoObj reservationProtoObj : reservationProtoObjs.getReservationList()) {
                Reservation reservation=(fromProtoObjToEntity(reservationProtoObj));
                reservations.add(reservation);
            }
            return reservations;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reservation> getReservationsByUserName(String userName) {
        try {
            proto.Reservation.ReservationProtoList reservationProtoObjs = getStub().getReservationsByUserName(StringValue.of(userName));
            List<Reservation> reservations=new ArrayList<>();
            for (proto.Reservation.ReservationProtoObj reservationProtoObj : reservationProtoObjs.getReservationList()) {
                Reservation reservation=(fromProtoObjToEntity(reservationProtoObj));
                reservations.add(reservation);
            }
            return reservations;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private proto.Reservation.ReservationProtoObj fromEntityToProtoObj(Reservation reservation)
    {
        // Build the ReservationProtoObj
        return proto.Reservation.ReservationProtoObj.newBuilder()
                .setId(reservation.getId())
                .setCarId(reservation.getCarId())
                .setUserName(reservation.getUserName())
                .setStartDate(convertToTimestamp(reservation.getStartDate()))
                .setEndDate(convertToTimestamp(reservation.getEndDate()))
                .setTotalPrice(reservation.getTotalPrice())
                .build();
    }

    private Reservation fromProtoObjToEntity(proto.Reservation.ReservationProtoObj reservationProtoObj) {
        return new Reservation(
                reservationProtoObj.getId(),
                reservationProtoObj.getCarId(),
                reservationProtoObj.getUserName(),
                convertToLocalDateTime(reservationProtoObj.getStartDate()),
                convertToLocalDateTime(reservationProtoObj.getEndDate()),
                reservationProtoObj.getTotalPrice()
        );
    }

    private Timestamp convertToTimestamp(LocalDateTime localDateTime) {
        return Timestamp.newBuilder()
                .setSeconds(localDateTime.toEpochSecond(ZoneOffset.UTC))
                .setNanos(localDateTime.getNano())
                .build();
    }

    private LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
        return LocalDateTime.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos(), ZoneOffset.UTC);
    }
}
