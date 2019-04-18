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
    
    
//    @Column(unique = true)
//    @NotNull(message = "part code cannot be null")
    
    private String cnBempID;
   // @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
//    private double BaseSalary;
    private double pensiun;
    private double insurance;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empid", referencedColumnName= "empID", nullable = false)
    private CNB CnB;
    //private Set<CNBItem> Items;
    //private boolean status;

    public CNBItem() {
    }

    public CNBItem(String cnBempID, double pensiun, double insurance, CNB CnB) {
        this.cnBempID = cnBempID;
        this.pensiun = pensiun;
        this.insurance = insurance;
        this.CnB = CnB;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcnBempID() {
        return cnBempID;
    }

    public void setCnBempID(String cnBempID) {
        this.cnBempID = cnBempID;
    }

    public CNB getCnB() {
        return CnB;
    }

    public void setCnB(CNB CnB) {
        this.CnB = CnB;
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
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.cnBempID);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.pensiun) ^ (Double.doubleToLongBits(this.pensiun) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.insurance) ^ (Double.doubleToLongBits(this.insurance) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.CnB);
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
        if (!Objects.equals(this.cnBempID, other.cnBempID)) {
            return false;
        }
        if (!Objects.equals(this.CnB, other.CnB)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public boolean sameIdentityAs(CNBItem other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
