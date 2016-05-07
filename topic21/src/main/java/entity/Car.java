package entity;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Leonid on 31.03.2016.
 */
public class Car {
    private Long car_id;
    private Owner owner;
    private String developer;
    private String model;

    private String vin;
    @SerializedName("describe")
    private String describe_more;
    @SerializedName("year")
    private int created;

    public Car() {
    }

    public Car(Long car_id, Owner owner, String developer, String model, String vin, String describe_more, int created) {
        this.car_id = car_id;
        this.owner = owner;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
}


