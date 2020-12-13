package com.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "mikencobrandnew", catalog = "")
public class CategoryEntity {
    private int categoryId;
    private String nameCategory;
    private String imgCategory;

    @Id
    @Column(name = "categoryId")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "nameCategory")
    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Basic
    @Column(name = "Img_Category")
    public String getImgCategory() {
        return imgCategory;
    }

    public void setImgCategory(String imgCategory) {
        this.imgCategory = imgCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return categoryId == that.categoryId && Objects.equals(nameCategory, that.nameCategory) && Objects.equals(imgCategory, that.imgCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, nameCategory, imgCategory);
    }
}
