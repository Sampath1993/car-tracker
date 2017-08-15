package io.egen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Car.findAll",
                query = "SELECT car FROM Car car ORDER BY car.vin DESC")
       // @NamedQuery(name = "Employee.findByEmail",
         //       query = "SELECT emp FROM Employee emp WHERE emp.email=:paramEmail")
})
public class Car{

    @Id
    private String vin;

    private double latitude;

    private double longitude;

    private String timestamp;

    private double fuelVolume;

    private int speed;

    private int engineHp;

    private boolean checkEngineLightOn;

    private boolean engineCoolantLow;

    private boolean cruiseControlOn;

    private int engineRPM;

    private Tires tires = new Tires();

    public String getId() {
        return vin;
    }

    public void setId(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRPM() {
        return engineRPM;
    }

    public void setEngineRPM(int engineRPM) {
        this.engineRPM = engineRPM;
    }

    public void setTires(int frontLeft, int frontRight, int rearLeft, int rearRight)
    {
        tires.setFrontLeft(frontLeft);
        tires.setFrontRight(frontRight);
        tires.setRearLeft(rearLeft);
        tires.setRearRight(rearRight);
    }

    public Tires getTires()
    {
        Tires temp = new Tires();

        temp.setFrontLeft(tires.getFrontLeft());
        temp.setFrontRight(tires.getFrontRight());
        temp.setRearLeft(tires.getRearLeft());
        temp.setRearRight(tires.getRearRight());

        return temp;
    }
}