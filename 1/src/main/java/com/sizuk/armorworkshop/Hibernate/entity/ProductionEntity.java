package com.sizuk.armorworkshop.Hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "production", schema = "", catalog = "workshop_armor_base")
public class ProductionEntity {
    private int id;
    private String albumName;
    private String albumPhotoUrl;
    private ProductionEntity productionByLink;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "album_name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Basic
    @Column(name = "album_photo_url", nullable = true, insertable = true, updatable = true, length = 450)
    public String getAlbumPhotoUrl() {
        return albumPhotoUrl;
    }

    public void setAlbumPhotoUrl(String albumPhotoUrl) {
        this.albumPhotoUrl = albumPhotoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductionEntity that = (ProductionEntity) o;

        if (id != that.id) return false;
        if (albumName != null ? !albumName.equals(that.albumName) : that.albumName != null) return false;
        if (albumPhotoUrl != null ? !albumPhotoUrl.equals(that.albumPhotoUrl) : that.albumPhotoUrl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (albumName != null ? albumName.hashCode() : 0);
        result = 31 * result + (albumPhotoUrl != null ? albumPhotoUrl.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "link", referencedColumnName = "id")
    public ProductionEntity getProductionByLink() {
        return productionByLink;
    }

    public void setProductionByLink(ProductionEntity productionByLink) {
        this.productionByLink = productionByLink;
    }

    @Override
    public String toString() {
        return "ProductionEntity{" +
                "id=" + id +
                ", albumName='" + albumName + '\'' +
                ", albumPhotoUrl='" + albumPhotoUrl + '\'' +
                ", productionByLink=" + productionByLink +
                '}';
    }
}
