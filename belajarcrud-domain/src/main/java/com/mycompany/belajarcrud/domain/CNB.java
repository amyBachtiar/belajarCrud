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
import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
    private String cnbID;
    private boolean cnbStatus;
    private String cnbDesc;
  
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cnbsalaryID", referencedColumnName = "payrollID", insertable = false, updatable = false)
//    private Payroll Salary;
    
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name="cnbitemID",referencedColumnName = "cnbID", insertable = false, updatable = false)
//    private Set<CNBItem> cnbItems = new HashSet<> ();
    //private Set<CNBItem> Items;
    //private boolean status;
    
    @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "empid")
    private Employee employee;

    public CNB() {
    }

    public CNB( 
            String cnbID, 
            boolean cnbStatus,
            String cnbDesc,
            Payroll Salary, 
            Set<CNBItem> cnbItems,
            Employee employee) {

        this.cnbID = cnbID;
        this.cnbStatus = cnbStatus;
        this.cnbDesc = cnbDesc;
//        this.Salary = Salary;
//        this.cnbItems = cnbItems;
        this.employee = employee;
        
    }

    public String getCnbID() {
        return cnbID;
    }

    public void setCnbID(String cnbID) {
        this.cnbID = cnbID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


//    public Payroll getSalary() {
//        return Salary;
//    }
//
//    public void setSalary(Payroll Salary) {
//        this.Salary = Salary;
//    }
//
//
//    public Set<CNBItem> getCnbItems() {
//        return cnbItems;
//    }
//
//    public void setCnbItems(Set<CNBItem> cnbItems) {
//        this.cnbItems = cnbItems;
//    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cnbID);
//        hash = 59 * hash + Objects.hashCode(this.Salary);
//        hash = 59 * hash + Objects.hashCode(this.cnbItems);
        return hash;
    }

    public boolean isCnbStatus() {
        return cnbStatus;
    }

    public void setCnbStatus(boolean cnbStatus) {
        this.cnbStatus = cnbStatus;
    }

    public String getCnbDesc() {
        return cnbDesc;
    }

    public void setCnbDesc(String cnbDesc) {
        this.cnbDesc = cnbDesc;
    }

    
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final CNB other = (CNB) obj;
//        if (!Objects.equals(this.cnbID, other.cnbID)) {
//            return false;
//        }
////        if (!Objects.equals(this.Salary, other.Salary)) {
////            return false;
////        }
////        if (!Objects.equals(this.cnbItems, other.cnbItems)) {
////            return false;
////        }
//           
//        return true;
//    }


   
    
    
    @Override
    public boolean sameIdentityAs(CNB other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}