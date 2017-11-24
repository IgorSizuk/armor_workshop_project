package com.sizuk.armorworkshop.Hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "albom_photos", schema = "", catalog = "workshop_armor_base")
public class AlbomPhotosEntity {
    private int id;
    private String photoUrl;
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
    @Column(name = "photo_url", nullable = true, insertable = true, updatable = true, length = 450)
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbomPhotosEntity that = (AlbomPhotosEntity) o;

        if (id != that.id) return false;
        if (photoUrl != null ? !photoUrl.equals(that.photoUrl) : that.photoUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
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
        return "AlbomPhotosEntity{" +
                "id=" + id +
                ", photoUrl='" + photoUrl + '\'' +
                ", productionByAlbumId=" + productionByAlbumId +
                '}';
    }
}
