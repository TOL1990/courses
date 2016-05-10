package entity;

/**
 * Created by Leonid on 31.03.2016.
 */
public class Lot {
    private Long lotId;
    private Car car;
    private int price;

    public Lot(){}

    public Lot(Long lotId, Car car, int price) {
        this.lotId = lotId;
        this.car = car;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "lotId=" + lotId +
                ", car=" + car +
                ", price=" + price +
                '}';
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
