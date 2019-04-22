/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import com.mycompany.belajarcrud.domain.CNBItem;
import java.util.Objects;
import java.util.Set;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;

/**
 *
 * @author HP
 */

@Entity
@Table(name = "MST_CNB")

public class CNB implements EntityObject<CNB>{
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    
//    @Column(unique = true)
//    @NotNull(message = "part code cannot be null")
    private String empName;
    private String empID;
   // @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
    private double BaseSalary;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="cnbitemID",referencedColumnName = "empid")
    private Set<CNBItem> cnbItems;
    //private Set<CNBItem> Items;
    //private boolean status;

    public CNB() {
    }

    public CNB(String empName, String empID, double BaseSalary, Set<CNBItem> cnbItems) {
        this.empName = empName;
        this.empID = empID;
        this.BaseSalary = BaseSalary;
        this.cnbItems = cnbItems;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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

    public Set<CNBItem> getCnbItems() {
        return cnbItems;
    }

    public void setCnbItems(Set<CNBItem> cnbItems) {
        this.cnbItems = cnbItems;
    }

   
    
    
    @Override
    public boolean sameIdentityAs(CNB other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
