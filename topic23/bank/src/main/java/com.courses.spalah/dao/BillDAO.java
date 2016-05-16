package com.courses.spalah.dao;

import com.courses.spalah.model.Bill;
import com.courses.spalah.model.Client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by Leonid on 14.05.2016.
 */
public interface BillDAO extends Serializable
{
    public Collection<Bill> getBillsByClient(Client client);
    public Bill findByNumber(Long billNumber);
    public void save(Bill bill);
    public void update(Bill bill,BigDecimal summ, boolean znak);
}
