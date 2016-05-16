package com.courses.spalah.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Leonid on 14.05.2016.
 */
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "inn")
    private Long inn;

    @Column(name = "first_name", nullable = true)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", orphanRemoval = true)
    private Collection<Bill> bills = new ArrayList<Bill>();
    public Client(){
        this.bills = null;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
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

    public Collection<Bill> getBills() {
        return bills;
    }

    public void setBills(Collection<Bill> bills) {
        this.bills = bills;
    }

    public Client(Long inn, String firstName, String lastName) {
        this.inn = inn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", Имя ='" + firstName + '\'' +
                ", Фамилия ='" + lastName + '\'' +
                "ИНН=" + inn +

                '}';
    }
}
