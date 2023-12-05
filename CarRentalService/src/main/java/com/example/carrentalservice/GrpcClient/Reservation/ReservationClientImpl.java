package com.example.carrentalservice.GrpcClient.Reservation;

import com.example.carrentalservice.GrpcClient.ManagedChannelProvider;
import com.example.carrentalservice.model.Reservation;
import com.google.protobuf.Timestamp;
import com.google.type.DateTime;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;
import proto.ReservationProtoServiceGrpc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static com.example.carrentalservice.GrpcClient.User.UserClientImpl.fromProtoObjToEntity;
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

    private proto.Reservation.ReservationProtoObj fromEntityToProtoObj(Reservation reservation)
    {
        // Build the ReservationProtoObj
        return proto.Reservation.ReservationProtoObj.newBuilder()
                .setId(reservation.getId())
                .setCarId(reservation.getCarId())
                .setUserId(reservation.getUserId())
                .setStartDate(convertToTimestamp(reservation.getStartDate()))
                .setEndDate(convertToTimestamp(reservation.getEndDate()))
                .setTotalPrice(reservation.getTotalPrice())
                .build();
    }

    private Reservation fromProtoObjToEntity(proto.Reservation.ReservationProtoObj reservationProtoObj) {
        return new Reservation(
                reservationProtoObj.getId(),
                reservationProtoObj.getCarId(),
                reservationProtoObj.getUserId(),
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
