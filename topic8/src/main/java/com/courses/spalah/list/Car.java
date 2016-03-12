package com.courses.spalah.list;

/**
 * Вам необходимо понять, что не хватаем этому классу, чтобы он имел возможность
 * учавствовать в коллекциях (правильно)
 *
 * @author Ievgen Tararaka
 */
public class Car {
    private int priceInDollars;
    private String modelName;

    @Override ///Затестить, коли че передалать
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (priceInDollars != car.priceInDollars) return false;
        return modelName != null ? modelName.equals(car.modelName) : car.modelName == null;

    }

    @Override
    public int hashCode() {// затестить, если тест пройдет выкинуть
        int result = priceInDollars;
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        return result;
    }

    public Car(int priceInDollars, String modelName) {
        this.priceInDollars = priceInDollars;
        this.modelName = modelName;
    }

    public int getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(int priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
