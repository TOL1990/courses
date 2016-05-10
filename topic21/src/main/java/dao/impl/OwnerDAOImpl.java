package dao.impl;

import dao.OwnerDAO;
import entity.Owner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.cfg.Configuration;

import javax.swing.*;


/**
 * Created by Leonid on 06.05.2016.
 */
public class OwnerDAOImpl implements OwnerDAO {
    @Override
    public void addOwner(Owner owner) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(owner);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

    }

    @Override
    public void updateOwner (Long Owner_id, Owner owner) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(owner);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Owner getOwnerById(Long owner_id) throws SQLException {
        Session session = null;
        Owner owner = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            owner = (Owner) session.load(Owner.class, owner_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return owner;
    }

    @Override
    public Collection getAllOwners() throws SQLException {
        Session session = null;
        List owners = new ArrayList<Owner>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            owners = session.createCriteria(Owner.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return owners;
    }

    @Override
    public void deleteOwner(Owner owner) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(owner);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Owner findOwnerByFirstName(String firstName) throws SQLException {
        Session session = null;
        Owner owner = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            owner = (Owner) session.load(Owner.class, firstName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'FirstName'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return owner;

    }
}
