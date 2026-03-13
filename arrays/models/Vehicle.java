package arrays.models;

public class Vehicle {

    private String brand;
    private String model;
    private String color;
    private String year;
    private String price;
    private String type;
    private String fuel;
    private String transmission;
    private String engine;

    public Vehicle(String brand, String model, String color, String year, String price, String type, String fuel, String transmission, String engine) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.type = type;
        this.fuel = fuel;
        this.transmission = transmission;
        this.engine = engine;
    }

    public Vehicle() {}

    public Vehicle(String brand, String color) {
        this.brand = brand;
        this.color = color;
    } 

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public String getYear() {   
        return year;
    }
    public String getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public String getFuel() {
        return fuel;
    }
    public String getTransmission() {
        return transmission;
    }
    public String getEngine() {
        return engine;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setYear(String year) {
        this.year = year;
    }

}