package com.sizuk.armorworkshop.Hibernate.dao;

import com.sizuk.armorworkshop.Hibernate.entity.AdminEntity;

import java.sql.SQLException;
import java.util.List;


public interface AdminDAO {

    //create
    void addAdmin(AdminEntity admin) throws SQLException;

    //read
    AdminEntity readAdmin(int id) throws SQLException;

    List<AdminEntity>  getAllAdmins();

    AdminEntity checkAdmin(String login);

    //update
    void updateAdmin(AdminEntity admin);

    //delete
    void deleteAdmin(int id);
}
