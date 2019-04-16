package com.mycompany.belajarcrud.domain;

import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mega
 */
@Entity
@Table(name="MST_COMPANY")
public class Company implements EntityObject<Company>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String companyName;
    private String companyDesc;
    
    public Company(){
    }
    
    public Company(String companyName, String companyDesc) {
        this.companyName = companyName;
        this.companyDesc = companyDesc;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.companyName);
        hash = 83 * hash + Objects.hashCode(this.companyDesc);
        return hash;
    }
    
    @Override
    public boolean sameIdentityAs(Company other) {
        return this.equals(other);
    }
}
