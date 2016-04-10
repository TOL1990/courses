package home12.Core;

/**
 * Created by Leonid on 31.03.2016.
 */
public class Car {
    private int car_id;
    private String developer;
    private String model;
    private String vin;
    private String describe_more;
    private int created;
    private int owner_id;

    public Car() {
    }

    public Car(int car_id, String developer, String model, String vin, String describe, int created, int owner_id) {
        this.car_id = car_id;
        this.developer = developer;
        this.model = model;
        this.vin = vin;
        this.describe_more = describe;
            this.created = created;
        this.owner_id = owner_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescribe() {
        return describe_more;
    }

    public void setDescribe(String describe) {
        this.describe_more = describe;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }


    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id = " + car_id +
                ", developer = '" + developer + '\'' +
                ", model = '" + model + '\'' +
                ", vin = '" + vin + '\'' +
                ", describe = '" + describe_more + '\'' +
                ", created = " + created +
                ", owner_id = " + owner_id +
                '}';
    }
}
