package home12.Core;

/**
 * Created by Leonid on 31.03.2016.
 */
public class Lot {
    int lotId;
    int carId;
    int ownerId;
    int price;

    public Lot(){}
    public Lot(int lotId, int carId, int ownerId, int price) {
        this.lotId = lotId;
        this.carId = carId;
        this.ownerId = ownerId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "lotId=" + lotId +
                ", carId=" + carId +
                ", ownerId=" + ownerId +
                ", price=" + price +
                '}';
    }

    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
