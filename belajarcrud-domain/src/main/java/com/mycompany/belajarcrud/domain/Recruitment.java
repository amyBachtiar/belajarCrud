package com.mycompany.belajarcrud.domain;

import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ilma
 */

@Entity
@Table(name = "MST_RECRUITMENT")
public class Recruitment implements EntityObject<Recruitment> {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column
    @NotNull(message = "Recruitment_ID Harus diIsi")
    private String recID;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "companyID", nullable = false)
    private Company company;
    
    private String recType;
    private boolean status;

    public Recruitment() {
    }

    public Recruitment(String recID, Company company, String recType, boolean status) {
        this.recID = recID;
        this.company = company;
        this.recType = recType;
        this.status = status;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecID() {
        return recID;
    }

    public void setRecID(String recID) {
        this.recID = recID;
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.recID);
        hash = 23 * hash + Objects.hashCode(this.company);
        hash = 23 * hash + Objects.hashCode(this.recType);
        hash = 23 * hash + (this.status ? 1 : 0);
        return hash;
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
        final Recruitment other = (Recruitment) obj;
        return true;
    }
    
    

    
    @Override
    public boolean sameIdentityAs(Recruitment other) {
        // TODO Auto-generated method stub  
        return this.equals(other);
    }

}