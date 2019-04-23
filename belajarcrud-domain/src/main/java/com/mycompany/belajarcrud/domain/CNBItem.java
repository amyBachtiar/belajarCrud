/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Objects;
import java.util.Set;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;

/**
 *
 * @author HP
 */

@Entity
@Table(name = "CNB_Item")
@Inheritance(strategy = InheritanceType.JOINED)
public class CNBItem implements EntityObject<CNBItem>{
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String cnbitemID;

    private double pensiun;
    private double insurance;

    public CNBItem() {
    }

    public CNBItem(String cnbitemID, double pensiun, double insurance) {
        this.cnbitemID = cnbitemID;
        this.pensiun = pensiun;
        this.insurance = insurance;
//        this.CnB = CnB;
    }

    public String getCnbitemID() {
        return cnbitemID;
    }

    public void setCnbitemID(String cnbitemID) {
        this.cnbitemID = cnbitemID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public double getPensiun() {
        return pensiun;
    }

    public void setPensiun(double pensiun) {
        this.pensiun = pensiun;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.cnbitemID);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.pensiun) ^ (Double.doubleToLongBits(this.pensiun) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.insurance) ^ (Double.doubleToLongBits(this.insurance) >>> 32));
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
        final CNBItem other = (CNBItem) obj;
        if (Double.doubleToLongBits(this.pensiun) != Double.doubleToLongBits(other.pensiun)) {
            return false;
        }
        if (Double.doubleToLongBits(this.insurance) != Double.doubleToLongBits(other.insurance)) {
            return false;
        }
        if (!Objects.equals(this.cnbitemID, other.cnbitemID)) {
            return false;
        }
        return true;
    }

    

    
    
    @Override
    public boolean sameIdentityAs(CNBItem other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
