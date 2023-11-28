package com.example.carrentalservice.model;

import com.example.carrentalservice.model.Enums.CarStatus;

public class Car
{
    private int Id;
    private String Brand;
    private String Model;
    private String BodyType;
    private int HorsePower;
    private String FuelType;
    private String Gearbox;
    private String Color;
    private String Description;
    private int PricePerDay;
    private CarStatus Status;
    public Car(int id, String brand, String model, String bodyType, int horsePower, String fuelType, String gearbox, String color, String description, int pricePerDay, CarStatus status) {
        this.Id = id;
        this.Brand = brand;
        this.Model = model;
        this.BodyType = bodyType;
        this.HorsePower = horsePower;
        this.FuelType = fuelType;
        this.Gearbox = gearbox;
        this.Color = color;
        this.Description = description;
        this.PricePerDay = pricePerDay;
        this.Status = status;
    }
    public Car() {
        CarStatus status = CarStatus.AVAILABLE;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
    public String getBrand() {
        return Brand;
    }
    public void setBrand(String brand) {
        this.Brand = brand;
    }
    public String getModel() {
        return Model;
    }
    public void setModel(String model) {
        this.Model = model;
    }
    public String getBodyType() {
        return BodyType;
    }
    public void setBodyType(String bodyType) {
        this.BodyType = bodyType;
    }
    public int getHorsePower() {
        return HorsePower;
    }
    public void setHorsePower(int horsePower) {
        this.HorsePower = horsePower;
    }
    public String getFuelType() {
        return FuelType;
    }
    public void setFuelType(String fuelType) {
        this.FuelType = fuelType;
    }
    public String getGearbox() {
        return Gearbox;
    }
    public void setGearbox(String gearbox) {
        this.Gearbox = gearbox;
    }
    public String getColor() {
        return Color;
    }
    public void setColor(String color) {
        this.Color = color;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        this.Description = description;
    }
    public int getPricePerDay() {
        return PricePerDay;
    }
    public void setPricePerDay(int pricePerDay) {
        this.PricePerDay = pricePerDay;
    }
    public CarStatus getStatus() {
        return Status;
    }
    public void setStatus(CarStatus status) {
        this.Status = status;
    }
}
