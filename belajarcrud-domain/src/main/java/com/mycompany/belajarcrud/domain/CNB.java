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
 * @author William
 */
@Entity
@Table(name = "MST_CNB")
@Inheritance(strategy = InheritanceType.JOINED)
public class CNB implements EntityObject<CNB> {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    
//    @Column(unique = true)
//    @NotNull(message = "part code cannot be null")
    private String empName;
    private String empID;
   // @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
    private double BaseSalary;
    
    //private Set<CNBItem> Items;
    //private boolean status;

    public CNB() {
    }

    public CNB(String empName, String empID, double BaseSalary) {
        this.empName = empName;
        this.empID = empID;
        this.BaseSalary = BaseSalary;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.empName);
        hash = 89 * hash + Objects.hashCode(this.empID);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.BaseSalary) ^ (Double.doubleToLongBits(this.BaseSalary) >>> 32));
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
        final CNB other = (CNB) obj;
        if (Double.doubleToLongBits(this.BaseSalary) != Double.doubleToLongBits(other.BaseSalary)) {
            return false;
        }
        if (!Objects.equals(this.empName, other.empName)) {
            return false;
        }
        if (!Objects.equals(this.empID, other.empID)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public boolean sameIdentityAs(CNB other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
