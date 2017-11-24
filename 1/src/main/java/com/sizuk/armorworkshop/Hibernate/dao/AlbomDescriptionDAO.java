package com.sizuk.armorworkshop.Hibernate.dao;

import com.sizuk.armorworkshop.Hibernate.entity.AlbomDescriptionEntity;


import java.sql.SQLException;
import java.util.List;


public interface AlbomDescriptionDAO {
    //create
    void addAlbomDescription(AlbomDescriptionEntity albomDescriptionEntity) throws SQLException;

    //read
    AlbomDescriptionEntity readAlbomDescription(int id) throws SQLException;

    List<AlbomDescriptionEntity> getAllAlbomDescriptions();

    //update
    void updateAlbomDescription(AlbomDescriptionEntity albomDescriptionEntity);

    //delete
    void deleteAlbomDescription(int id);
}
