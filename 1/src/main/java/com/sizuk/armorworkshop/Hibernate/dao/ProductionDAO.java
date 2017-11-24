package com.sizuk.armorworkshop.Hibernate.dao;


import com.sizuk.armorworkshop.Hibernate.entity.ProductionEntity;

import java.sql.SQLException;
import java.util.List;

public interface ProductionDAO {

    //create
    void addProduction(ProductionEntity productionEntity) throws SQLException;

    //read
    ProductionEntity readProduction(int id) throws SQLException;

    List<ProductionEntity> getAllProductions();

    //update
    void updateProduction(ProductionEntity productionEntity);

    //delete
    void deleteProduction(int id);

}
