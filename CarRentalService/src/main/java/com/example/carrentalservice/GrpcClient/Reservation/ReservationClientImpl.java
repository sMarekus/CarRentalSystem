package com.example.carrentalservice.GrpcClient.Reservation;

import com.example.carrentalservice.GrpcClient.ManagedChannelProvider;
import com.example.carrentalservice.model.Reservation;
import com.google.protobuf.Timestamp;
import com.google.type.DateTime;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;
import proto.ReservationProtoServiceGrpc;

import java.time.Instant;
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
        Timestamp startDate = Timestamp.newBuilder()
                .setSeconds(reservation.getStartDate().getSeconds()) // Assuming startDate is DateTime
                .setNanos(reservation.getStartDate().getNanos()) // Assuming startDate is DateTime
                .build();

        Timestamp endDate = Timestamp.newBuilder()
                .setSeconds(reservation.getEndDate().getSeconds()) // Assuming endDate is DateTime
                .setNanos(reservation.getEndDate().getNanos()) // Assuming endDate is DateTime
                .build();

        // Build the ReservationProtoObj
        return proto.Reservation.ReservationProtoObj.newBuilder()
                .setId(reservation.getId())
                .setCarId(reservation.getCarId())
                .setUserId(reservation.getUserId())
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setTotalPrice(reservation.getTotalPrice())
                .build();
    }

    private Reservation fromProtoObjToEntity(proto.Reservation.ReservationProtoObj reservationProtoObj) {
        // Convert Timestamp objects to DateTime objects
        DateTime startDate = convertTimestampToDateTime(reservationProtoObj.getStartDate());
        DateTime endDate = convertTimestampToDateTime(reservationProtoObj.getEndDate());

        // Create and return the Reservation object
        return new Reservation(
                reservationProtoObj.getId(),
                reservationProtoObj.getCarId(),
                reservationProtoObj.getUserId(),
                startDate,
                endDate,
                reservationProtoObj.getTotalPrice()
        );
    }

    private DateTime convertTimestampToDateTime(Timestamp timestamp) {
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();

        long milliseconds = seconds * 1000 + nanos / 1_000_000; // Convert nanoseconds to milliseconds

        DateTime dateTime = DateTime.newBuilder()
                .setSeconds((int) (milliseconds / 1000))
                .setNanos((int) ((milliseconds % 1000) * 1_000_000))
                .build();

        return dateTime;
    }
}
