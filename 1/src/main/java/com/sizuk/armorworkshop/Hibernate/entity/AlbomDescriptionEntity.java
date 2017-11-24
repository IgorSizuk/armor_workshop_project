package com.sizuk.armorworkshop.Hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "albom_description", schema = "", catalog = "workshop_armor_base")
public class AlbomDescriptionEntity {
    private int id;
    private String description;
    private ProductionEntity productionByAlbumId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 450)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbomDescriptionEntity that = (AlbomDescriptionEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    public ProductionEntity getProductionByAlbumId() {
        return productionByAlbumId;
    }

    public void setProductionByAlbumId(ProductionEntity productionByAlbumId) {
        this.productionByAlbumId = productionByAlbumId;
    }

    @Override
    public String toString() {
        return "AlbomDescriptionEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", productionByAlbumId=" + productionByAlbumId +
                '}';
    }
}
