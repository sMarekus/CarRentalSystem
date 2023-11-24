package com.example.carrentalservice.GrpcClient.car;

import com.example.carrentalservice.GrpcClient.ManagedChannelProvider;
import com.example.carrentalservice.model.Car;
import com.example.carrentalservice.model.User;
import com.example.carrentalservice.model.enums.CarStatus;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;
import proto.CarProtoServiceGrpc;
import proto.UserProtoServiceGrpc;

@Service
public class CarClientImpl implements ICarClient {
    private CarProtoServiceGrpc.CarProtoServiceBlockingStub carStub;

    public CarProtoServiceGrpc.CarProtoServiceBlockingStub getCarStub() {
        if (carStub == null) {
            ManagedChannel channel = ManagedChannelProvider.getChannel();
            carStub = CarProtoServiceGrpc.newBlockingStub(channel);
        }
        return carStub;
    }

    @Override
    public Car createCar(Car car) {
        try {
            System.out.println("Creating car");
            proto.Car.CarProtoObj carProtoObj = fromEntityToProtoObj(car);
            proto.Car.CarProtoObj protoObjFromServer = getCarStub().createCar(carProtoObj);
            return fromProtoObjToEntity(protoObjFromServer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private proto.Car.CarProtoObj fromEntityToProtoObj(Car car) {
        proto.Car.CarProtoObj.Builder builder = proto.Car.CarProtoObj.newBuilder()
                .setId(car.getId())
                .setBrand(car.getBrand())
                .setModel(car.getModel())
                .setBodyType(car.getBodyType())
                .setHorsePower(car.getHorsePower())
                .setFuelType(car.getFuelType())
                .setGearbox(car.getGearbox())
                .setColor(car.getColor())
                .setDescription(car.getDescription())
                .setPricePerDay(car.getPricePerDay())
                .setStatus(mapCarStatus(car.getStatus()));
        return builder.build();
    }

    public static Car fromProtoObjToEntity(proto.Car.CarProtoObj carProtoObj) {
        Car carEntity = new Car();
        carEntity.setId(carProtoObj.getId());
        carEntity.setBrand(carProtoObj.getBrand());
        carEntity.setModel(carProtoObj.getModel());
        carEntity.setBodyType(carProtoObj.getBodyType());
        carEntity.setHorsePower(carProtoObj.getHorsePower());
        carEntity.setFuelType(carProtoObj.getFuelType());
        carEntity.setGearbox(carProtoObj.getGearbox());
        carEntity.setColor(carProtoObj.getColor());
        carEntity.setDescription(carProtoObj.getDescription());
        carEntity.setPricePerDay(carProtoObj.getPricePerDay());
        carEntity.setStatus(mapProtoCarStatus(carProtoObj.getStatus()));
        return carEntity;
    }

    private proto.Car.CarStatus mapCarStatus(com.example.carrentalservice.model.enums.CarStatus status) {
        switch (status) {
            case AVAILABLE:
                return proto.Car.CarStatus.AVAILABLE;
            case RESERVED:
                return proto.Car.CarStatus.RESERVED;
            case UNAVAILABLE:
                return proto.Car.CarStatus.UNAVAILABLE;
            default:
                throw new IllegalArgumentException("Unknown CarStatus: " + status);
        }
    }

    private static com.example.carrentalservice.model.enums.CarStatus mapProtoCarStatus(proto.Car.CarStatus status) {
        switch (status) {
            case AVAILABLE:
                return com.example.carrentalservice.model.enums.CarStatus.AVAILABLE;
            case RESERVED:
                return com.example.carrentalservice.model.enums.CarStatus.RESERVED;
            case UNAVAILABLE:
                return com.example.carrentalservice.model.enums.CarStatus.UNAVAILABLE;
            default:
                throw new IllegalArgumentException("Unknown CarStatus: " + status);
        }
    }
}