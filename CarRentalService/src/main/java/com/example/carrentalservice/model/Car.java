package com.example.carrentalservice.model;
import com.example.carrentalservice.model.Enums.CarStatus;
public class Car
{
    private int id;
    private String brand;
    private String model;
    private String bodyType;
    private int horsePower;
    private String fuelType;
    private String gearbox;
    private String color;
    private String description;
    private int pricePerDay;
    private CarStatus status;
    public Car(int id, String brand, String model, String bodyType, int horsePower, String fuelType, String gearbox, String color, String description, int pricePerDay, CarStatus status) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.bodyType = bodyType;
        this.horsePower = horsePower;
        this.fuelType = fuelType;
        this.gearbox = gearbox;
        this.color = color;
        this.description = description;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }
    public Car() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getBodyType() {
        return bodyType;
    }
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    public int getHorsePower() {
        return horsePower;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public String getGearbox() {
        return gearbox;
    }
    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    public CarStatus getStatus() {
        return status;
    }
    public void setStatus(CarStatus status) {
        this.status = status;
    }
}
