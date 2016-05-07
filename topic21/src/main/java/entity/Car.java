package entity;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Leonid on 31.03.2016.
 */
public class Car {
    private Long car_id;
    private Long owner_id;
    private String developer;
    private String model;

    private String vin;
    @SerializedName("describe")
    private String describe_more;
    @SerializedName("year")
    private int created;

    public Car() {
    }

    public Car(Long car_id, Long owner_id, String developer, String model, String vin, String describe_more, int created) {
        this.car_id = car_id;
        this.owner_id = owner_id;
        this.developer = developer;
        this.model = model;
        this.vin = vin;
        this.describe_more = describe_more;
        this.created = created;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
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

    public String getDescribe_more() {
        return describe_more;
    }

    public void setDescribe_more(String describe_more) {
        this.describe_more = describe_more;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", owner_id=" + owner_id +
                ", developer='" + developer + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", describe_more='" + describe_more + '\'' +
                ", created=" + created +
                '}';
    }
}


