package com.example.carrentalservice.GrpcClient.Car;

import com.example.carrentalservice.GrpcClient.ManagedChannelProvider;
import com.example.carrentalservice.dto.CarFilterDto;
import com.example.carrentalservice.model.Car;
import com.google.protobuf.Int32Value;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;
import proto.CarProtoServiceGrpc;

import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("Creating car in CarClientImpl.java: " + car.toString());
        try {
            proto.Car.CarProtoObj carProtoObj = fromEntityToProtoObj(car);
            proto.Car.CarProtoObj protoObjFromServer = getCarStub().createCar(carProtoObj);
            return fromProtoObjToEntity(protoObjFromServer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> getCars(CarFilterDto dto) {
        try {
            proto.Car.CarFilterProtoObj filterProtoObj = fromDtoToProtoObj(dto);
            proto.Car.ListCarObj listCarObj = getCarStub().getCars(filterProtoObj);
            return fromListProtoObjToListEntity(listCarObj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car getCarById(int id) {
        try {
          proto.Car.CarProtoObj carProtoObj=getCarStub().getCarById(Int32Value.of(id));
            return fromProtoObjToEntity(carProtoObj);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car deleteCar(int id) {
        try {
            proto.Car.CarProtoObj carProtoObj=getCarStub().deleteCar(Int32Value.of(id));
            return fromProtoObjToEntity(carProtoObj);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car updateCar(Car car) {
        try {
            proto.Car.CarProtoObj carProtoObj = fromEntityToProtoObj(car);
            proto.Car.CarProtoObj protoObjFromServer = getCarStub().updateCar(Int32Value.of(car.getId()));
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

    public  Car fromProtoObjToEntity(proto.Car.CarProtoObj carProtoObj) {
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
    private proto.Car.CarFilterProtoObj fromDtoToProtoObj(CarFilterDto dto) {


        proto.Car.CarFilterProtoObj.Builder builder = proto.Car.CarFilterProtoObj.newBuilder();
        if (dto.getBrand() != null) builder.setBrand(dto.getBrand());
        if (dto.getModel() != null) builder.setModel(dto.getModel());
        if (dto.getBodyType() != null) builder.setBodyType(dto.getBodyType());
        if (dto.getHorsePower() != null) builder.setHorsePower(dto.getHorsePower());
        if (dto.getFuelType() != null) builder.setFuelType(dto.getFuelType());
        if (dto.getGearbox() != null) builder.setGearbox(dto.getGearbox());
        if (dto.getColor() != null) builder.setColor(dto.getColor());
        if (dto.getDescription() != null) builder.setDescription(dto.getDescription());
        if (dto.getPricePerDay() != null) builder.setPricePerDay(dto.getPricePerDay());
        if (dto.getStatus() != null) builder.setStatus(mapCarStatus(dto.getStatus()));
        return builder.build();

    }

    private List<Car> fromListProtoObjToListEntity(proto.Car.ListCarObj listCarObj) {
        return listCarObj.getCarListList().stream()
                .map(this::fromProtoObjToEntity)
                .collect(Collectors.toList());
    }
    private proto.Car.CarStatus mapCarStatus(com.example.carrentalservice.model.Enums.CarStatus status) {
        return switch (status) {
            case AVAILABLE -> proto.Car.CarStatus.AVAILABLE;
            case RESERVED -> proto.Car.CarStatus.RESERVED;
            case UNAVAILABLE -> proto.Car.CarStatus.UNAVAILABLE;
        };
    }

    private static com.example.carrentalservice.model.Enums.CarStatus mapProtoCarStatus(proto.Car.CarStatus status) {
        return switch (status) {
            case AVAILABLE -> com.example.carrentalservice.model.Enums.CarStatus.AVAILABLE;
            case RESERVED -> com.example.carrentalservice.model.Enums.CarStatus.RESERVED;
            case UNAVAILABLE -> com.example.carrentalservice.model.Enums.CarStatus.UNAVAILABLE;
            default -> throw new IllegalArgumentException("Unknown CarStatus: " + status);
        };
    }
}