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
    
    private String empID;
   // @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
    private double BaseSalary;
    private double pensiun;
    private double insurance;
    //private Set<CNBItem> Items;
    //private boolean status;

    public CNBItem() {
    }

    public CNBItem(String empID, double BaseSalary, double pensiun, double insurance) {
        this.empID = empID;
        this.BaseSalary = BaseSalary;
        this.pensiun = pensiun;
        this.insurance = insurance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public double getBaseSalary() {
        return BaseSalary;
    }

    public void setBaseSalary(double BaseSalary) {
        this.BaseSalary = BaseSalary;
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
    public boolean sameIdentityAs(CNBItem other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
