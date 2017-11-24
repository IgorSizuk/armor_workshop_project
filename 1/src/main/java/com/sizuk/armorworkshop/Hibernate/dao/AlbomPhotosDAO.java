package com.sizuk.armorworkshop.Hibernate.dao;

import com.sizuk.armorworkshop.Hibernate.entity.AlbomPhotosEntity;

import java.sql.SQLException;
import java.util.List;


public interface AlbomPhotosDAO {
    //create
    void addAlbomPhotos(AlbomPhotosEntity albomPhotosEntity) throws SQLException;

    //read
    AlbomPhotosEntity readAlbomPhotos(int id) throws SQLException;

    List<AlbomPhotosEntity> getAllAlbomPhotos();

    //update
    void updateAlbomPhotos(AlbomPhotosEntity albomPhotosEntity);

    //delete
    void deleteAlbomPhotos(int id);
}
