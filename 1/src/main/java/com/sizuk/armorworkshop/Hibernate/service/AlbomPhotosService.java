package com.sizuk.armorworkshop.Hibernate.service;

import com.sizuk.armorworkshop.Hibernate.bl.SessionUtil;
import com.sizuk.armorworkshop.Hibernate.dao.AlbomPhotosDAO;
import com.sizuk.armorworkshop.Hibernate.entity.AlbomPhotosEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.List;

public class AlbomPhotosService extends SessionUtil implements AlbomPhotosDAO {


    public void addAlbomPhotos(AlbomPhotosEntity albomPhotosEntity) throws SQLException {
        //create session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(albomPhotosEntity);

        //close session with a transaction
        closeTransactionSession();
    }

    public AlbomPhotosEntity readAlbomPhotos(int id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        AlbomPhotosEntity result = null;
        result = (AlbomPhotosEntity) session.createCriteria(AlbomPhotosEntity.class).add(Restrictions.eq("id", id)).uniqueResult();

        //close session with a transaction
        closeTransactionSession();
        return result;
    }

    public List<AlbomPhotosEntity> getAllAlbomPhotos() {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        List<AlbomPhotosEntity> albomPhotosEntityList = session.createCriteria(AlbomPhotosEntity.class).list();

        //close session with a transaction
        closeTransactionSession();

        return albomPhotosEntityList;
    }

    public void updateAlbomPhotos(AlbomPhotosEntity albomPhotosEntity) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        session.update(albomPhotosEntity);    //Update(productionEntity);

        //close session with a transaction
        closeTransactionSession();
    }

    public void deleteAlbomPhotos(int id) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();

        AlbomPhotosEntity albomPhotosEntity = new AlbomPhotosEntity();
        albomPhotosEntity.setId(id);
        session.delete(albomPhotosEntity);

        //close session with a transaction
        closeTransactionSession();
    }
}
