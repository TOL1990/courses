package entity;

/**
 * Created by Leonid on 31.03.2016.
 */
public class Lot {
    private Long lotId;
    private Long carId;
    private int price;

    public Lot(){}

    public Lot(Long lotId, Long carId, Long ownerId, int price) {
        this.lotId = lotId;
        this.carId = carId;
        this.price = price;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "lotId=" + lotId +
                ", carId=" + carId +
                ", price=" + price +
                '}';
    }
}
