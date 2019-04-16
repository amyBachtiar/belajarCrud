/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain;

import com.eksad.ddms.common.util.object.EntityObject;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 *
 * @author eksad
 */
@Entity
@Table(name = "MST_COMP")
public class Company implements EntityObject<Company>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String companyID;
    private String companyName;
    private String companyDesc;

    public Company() {
    }

    public Company(Integer id, String companyID, String companyName, String companyDesc) {
        this.id = id;
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyDesc = companyDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.companyID);
        hash = 31 * hash + Objects.hashCode(this.companyName);
        hash = 31 * hash + Objects.hashCode(this.companyDesc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        return true;
    }
    
    @Override
    public boolean sameIdentityAs(Company other) {
        return this.equals(other);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
