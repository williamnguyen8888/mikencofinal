package com.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "mikencobrandnew", catalog = "")
public class ProductEntity {
    private int productId;
    private Integer categoryId;
    private int quantity;
    private int price;
    private String description;
    private String productName;
    private String imgMain;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private Integer sizeS;
    private Integer sizeM;
    private Integer sizeL;
    private Integer sizeXl;
    private Integer sizeXxl;

    @Id
    @Column(name = "productId")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "categoryId")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "imgMain")
    public String getImgMain() {
        return imgMain;
    }

    public void setImgMain(String imgMain) {
        this.imgMain = imgMain;
    }

    @Basic
    @Column(name = "img1")
    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    @Basic
    @Column(name = "img2")
    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    @Basic
    @Column(name = "img3")
    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    @Basic
    @Column(name = "img4")
    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    @Basic
    @Column(name = "Size_S")
    public Integer getSizeS() {
        return sizeS;
    }

    public void setSizeS(Integer sizeS) {
        this.sizeS = sizeS;
    }

    @Basic
    @Column(name = "Size_M")
    public Integer getSizeM() {
        return sizeM;
    }

    public void setSizeM(Integer sizeM) {
        this.sizeM = sizeM;
    }

    @Basic
    @Column(name = "Size_L")
    public Integer getSizeL() {
        return sizeL;
    }

    public void setSizeL(Integer sizeL) {
        this.sizeL = sizeL;
    }

    @Basic
    @Column(name = "Size_XL")
    public Integer getSizeXl() {
        return sizeXl;
    }

    public void setSizeXl(Integer sizeXl) {
        this.sizeXl = sizeXl;
    }

    @Basic
    @Column(name = "Size_XXL")
    public Integer getSizeXxl() {
        return sizeXxl;
    }

    public void setSizeXxl(Integer sizeXxl) {
        this.sizeXxl = sizeXxl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId && quantity == that.quantity && price == that.price && Objects.equals(categoryId, that.categoryId) && Objects.equals(description, that.description) && Objects.equals(productName, that.productName) && Objects.equals(imgMain, that.imgMain) && Objects.equals(img1, that.img1) && Objects.equals(img2, that.img2) && Objects.equals(img3, that.img3) && Objects.equals(img4, that.img4) && Objects.equals(sizeS, that.sizeS) && Objects.equals(sizeM, that.sizeM) && Objects.equals(sizeL, that.sizeL) && Objects.equals(sizeXl, that.sizeXl) && Objects.equals(sizeXxl, that.sizeXxl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, categoryId, quantity, price, description, productName, imgMain, img1, img2, img3, img4, sizeS, sizeM, sizeL, sizeXl, sizeXxl);
    }
}
