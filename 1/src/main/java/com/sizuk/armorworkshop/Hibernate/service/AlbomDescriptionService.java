package com.sizuk.armorworkshop.Hibernate.service;

import com.sizuk.armorworkshop.Hibernate.bl.SessionUtil;
import com.sizuk.armorworkshop.Hibernate.dao.AlbomDescriptionDAO;
import com.sizuk.armorworkshop.Hibernate.entity.AlbomDescriptionEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.List;

public class AlbomDescriptionService extends SessionUtil implements AlbomDescriptionDAO {
    public void addAlbomDescription(AlbomDescriptionEntity albomDescriptionEntity) throws SQLException {
        //create session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(albomDescriptionEntity);

        //close session with a transaction
        closeTransactionSession();
    }

    public AlbomDescriptionEntity readAlbomDescription(int id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        AlbomDescriptionEntity result = null;
        result = (AlbomDescriptionEntity) session.createCriteria(AlbomDescriptionEntity.class).add(Restrictions.eq("id", id)).uniqueResult();

        //close session with a transaction
        closeTransactionSession();
        return result;
    }



    public List<AlbomDescriptionEntity> getAllAlbomDescriptions() {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        List<AlbomDescriptionEntity> albomDescriptionEntityList = session.createCriteria(AlbomDescriptionEntity.class).list();

        //close session with a transaction
        closeTransactionSession();

        return albomDescriptionEntityList;
    }

    public void updateAlbomDescription(AlbomDescriptionEntity albomDescriptionEntity) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        session.update(albomDescriptionEntity);    //Update(productionEntity);

        //close session with a transaction
        closeTransactionSession();
    }

    public void deleteAlbomDescription(int id) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        AlbomDescriptionEntity albomDescriptionEntity = new AlbomDescriptionEntity();
        albomDescriptionEntity.setId(id);
        session.delete(albomDescriptionEntity);

        //close session with a transaction
        closeTransactionSession();
    }
}
