package com.sizuk.armorworkshop.Hibernate.service;


import com.sizuk.armorworkshop.Hibernate.bl.SessionUtil;
import com.sizuk.armorworkshop.Hibernate.dao.AdminDAO;
import com.sizuk.armorworkshop.Hibernate.entity.AdminEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import java.sql.*;
import java.util.List;


public class AdminService extends SessionUtil implements AdminDAO {

    //create
    public void addAdmin(AdminEntity admin) throws SQLException{
        //create session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(admin);

        //close session with a transaction
        closeTransactionSession();
    }

    //read
    public AdminEntity readAdmin(int id) throws SQLException{
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        AdminEntity result = null;
        result = (AdminEntity) session.createCriteria(AdminEntity.class).add(Restrictions.eq("id", id)).uniqueResult();

        //close session with a transaction
        closeTransactionSession();
        return result;


    }

    public List<AdminEntity> getAllAdmins() {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        List<AdminEntity> admins = session.createCriteria(AdminEntity.class).list();

        //close session with a transaction
        closeTransactionSession();

        return admins;
    }

    public AdminEntity checkAdmin(String login) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        AdminEntity result = null;
        result = (AdminEntity) session.createCriteria(AdminEntity.class).add(Restrictions.eq("login", login)).uniqueResult();

        //close session with a transaction
        closeTransactionSession();

        return result;
    }

    //update
    public void updateAdmin(AdminEntity admin) {

        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        session.saveOrUpdate(admin);

        //close session with a transaction
        closeTransactionSession();
    }
    //delete
    public void deleteAdmin(int id) {

        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        AdminEntity deleteAdmin = new AdminEntity();
        deleteAdmin.setId(id);
        session.delete(deleteAdmin);

        //close session with a transaction
        closeTransactionSession();
    }
}
