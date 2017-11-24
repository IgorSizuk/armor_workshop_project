package com.sizuk.armorworkshop.web;


import com.sizuk.armorworkshop.Hibernate.bl.HibernateUtil;
import com.sizuk.armorworkshop.Hibernate.dao.ProductionDAO;
import com.sizuk.armorworkshop.Hibernate.entity.AlbomDescriptionEntity;
import com.sizuk.armorworkshop.Hibernate.service.AlbomDescriptionService;
import com.sizuk.armorworkshop.Hibernate.service.AlbomPhotosService;
import com.sizuk.armorworkshop.Hibernate.service.ProductionService;
import com.sizuk.armorworkshop.dao.DAOException;
import com.sizuk.armorworkshop.dao.dao.impl.*;
import com.sizuk.armorworkshop.dao.MySqlDaoFactory;
import org.hibernate.HibernateException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private HttpSession session;

    @Override
    public void sessionCreated(HttpSessionEvent event) {

        session = event.getSession();


        try {
            MySqlAdminDao adminDao = (MySqlAdminDao) new MySqlDaoFactory().getAdminDao();
            session.setAttribute("adminDao", adminDao);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        try {
            ProductionService productionService = new ProductionService();
            session.setAttribute("productionService", productionService);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            AlbomDescriptionService albomDescriptionService = new AlbomDescriptionService();
            session.setAttribute("albomDescriptionService", albomDescriptionService);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            AlbomPhotosService albomPhotosService = new AlbomPhotosService();
            session.setAttribute("albomPhotosService", albomPhotosService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*try {
            MySqlProductionDao productionDao = (MySqlProductionDao) new MySqlDaoFactory().getProductionDao();
            session.setAttribute("productionDao", productionDao);
        } catch (DAOException e) {
            e.printStackTrace();
        }*/

        /*try {
            MySqlAlbomDescriptionDao albomDescriptionDao = (MySqlAlbomDescriptionDao) new MySqlDaoFactory().getAlbomDescriptionDao();
            session.setAttribute("albomDescriptionDao", albomDescriptionDao);
        } catch (DAOException e) {
            e.printStackTrace();
        }*/



        /*try {
            MySqlAlbomPhotoDao albomPhotosDao = (MySqlAlbomPhotoDao) new MySqlDaoFactory().getAlbomPhotosDao();

            session.setAttribute("albomPhotosDao", albomPhotosDao);
        } catch (DAOException e) {
            e.printStackTrace();
        }*/

        try {
            MySqlMasterclasDao masterclassDao = (MySqlMasterclasDao) new MySqlDaoFactory().getMasterclassDao();
            session.setAttribute("masterclassDao", masterclassDao);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        try {
            MySqlMasterclasPhotoDao masterclassPhotoDao = (MySqlMasterclasPhotoDao) new MySqlDaoFactory().getMasterclassPhotoDao();
            session.setAttribute("masterclassPhotoDao", masterclassPhotoDao);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

        session = event.getSession();


        MySqlAdminDao adminDao = (MySqlAdminDao) session.getAttribute("adminDao");

        try {
            adminDao.close();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        /*try {
            HibernateUtil.shutdown();
        } catch (HibernateException e) {
            e.printStackTrace();
        }*/

        /*MySqlProductionDao productionDao = (MySqlProductionDao) session.getAttribute("productionDao");

        try {
            productionDao.close();
        } catch (DAOException e) {
            e.printStackTrace();
        }*/

        /*MySqlAlbomDescriptionDao albomDescriptionDao = (MySqlAlbomDescriptionDao) session.getAttribute("albomDescriptionDao");

        try {
            albomDescriptionDao.close();
        } catch (DAOException e) {
            e.printStackTrace();
        }*/

        /*MySqlAlbomPhotoDao albomPhotosDao = (MySqlAlbomPhotoDao) session.getAttribute("albomPhotosDao");

        try {
            albomPhotosDao.close();
        } catch (DAOException e) {
            e.printStackTrace();
        }*/

        MySqlMasterclasDao masterclassDao = (MySqlMasterclasDao) session.getAttribute("masterclassDao");

        try {
            masterclassDao.close();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        MySqlMasterclasPhotoDao masterclassPhotoDao = (MySqlMasterclasPhotoDao) session.getAttribute("masterclassPhotoDao");

        try {
            masterclassPhotoDao.close();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}