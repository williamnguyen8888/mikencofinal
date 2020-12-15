package com.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "typeofaccount", schema = "mikencobrandnew", catalog = "")
public class TypeofaccountEntity {
    private int typeAccountId;
    private String typeOfAccount;

    @Id
    @Column(name = "typeAccountId")
    public int getTypeAccountId() {
        return typeAccountId;
    }

    public void setTypeAccountId(int typeAccountId) {
        this.typeAccountId = typeAccountId;
    }

    @Basic
    @Column(name = "typeOfAccount")
    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeofaccountEntity that = (TypeofaccountEntity) o;
        return typeAccountId == that.typeAccountId && Objects.equals(typeOfAccount, that.typeOfAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeAccountId, typeOfAccount);
    }
}
