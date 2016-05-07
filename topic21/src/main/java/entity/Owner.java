package entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Leonid on 31.03.2016.
 */
public class Owner {
    private Long owner_id;
    private String firstName;
    private String lastName;
    @SerializedName("contact_phone")
    private String tel;

    public Owner(){}

    public Owner(Long owner_id, String firstName, String lastName, String tel) {
        this.owner_id = owner_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "owner_id=" + owner_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
