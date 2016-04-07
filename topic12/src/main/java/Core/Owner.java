package Core;

/**
 * Created by Leonid on 31.03.2016.
 */
public class Owner {
    private int owner_id;
    private String firstName;
    private String lastName;
    private String tel;

    public Owner(){}

    public Owner(int owner_id, String firstName, String lastName, String tel) {
        this.owner_id = owner_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "owner_id = " + owner_id +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", mobile number = '" + tel + '\'' +
                '}';
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
}
