package com.sizuk.armorworkshop.Hibernate.service;

import com.sizuk.armorworkshop.Hibernate.bl.SessionUtil;
import com.sizuk.armorworkshop.Hibernate.dao.ProductionDAO;
import com.sizuk.armorworkshop.Hibernate.entity.ProductionEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ProductionService extends SessionUtil implements ProductionDAO {

    public void addProduction(ProductionEntity productionEntity) throws SQLException {
        //create session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(productionEntity);

        //close session with a transaction
        closeTransactionSession();
    }

    public ProductionEntity readProduction(int id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        ProductionEntity result = null;
        result = (ProductionEntity) session.createCriteria(ProductionEntity.class).add(Restrictions.eq("id", id)).uniqueResult();

        //close session with a transaction
        closeTransactionSession();
        return result;
    }

    public List<ProductionEntity> getAllProductions() {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        List<ProductionEntity> productionEntityList = session.createCriteria(ProductionEntity.class).list();

        //close session with a transaction
        closeTransactionSession();

        return productionEntityList;
    }

    public void updateProduction(ProductionEntity productionEntity) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        session.update(productionEntity);    //Update(productionEntity);

        //close session with a transaction
        closeTransactionSession();


        /*Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            //session.merge(productionEntity);
            session.update(productionEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }*/
    }

    public void deleteProduction(int id) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        ProductionEntity deleteProductionEntity = new ProductionEntity();
        deleteProductionEntity.setId(id);
        session.delete(deleteProductionEntity);

        //close session with a transaction
        closeTransactionSession();
    }
}
