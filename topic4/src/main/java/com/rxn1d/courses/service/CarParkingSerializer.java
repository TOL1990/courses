package com.rxn1d.courses.service;

import com.rxn1d.courses.CarParking;

/**
 * Интерфейс сериализатора класса {@link CarParking}
 * TODO необходимо создать реализацию этого интерфейса
 *
 * @author Ievgen Tararaka
 */
public interface CarParkingSerializer {
    String serialize(CarParking carParking);
}
