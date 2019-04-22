package com.mycompany.belajarcrud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nadya
 */

@Entity
@Table(name = "MST_PAYROLL")
public class Payroll implements EntityObject<Payroll> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    @Column(unique = true)
    @NotNull(message = "payrollitemsID cannot be null")
    private String payrollID;
    private double baseSalary;
    private double totalPayroll;
   
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
    private Date payrollDate;
    
//    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="payrollID",referencedColumnName = "payrollID")
    private Set<Payrollitems>payItems;

    public Payroll() {
    }

    public Payroll(String payrollID, double baseSalary, double totalPayroll, Date payrollDate, Set<Payrollitems> payItems) {
        this.payrollID = payrollID;
        this.baseSalary = baseSalary;
        this.totalPayroll = totalPayroll;
        this.payrollDate = payrollDate;
        this.payItems = payItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(String payrollID) {
        this.payrollID = payrollID;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getTotalPayroll() {
        return totalPayroll;
    }

    public void setTotalPayroll(double totalPayroll) {
        this.totalPayroll = totalPayroll;
    }

    public Date getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(Date payrollDate) {
        this.payrollDate = payrollDate;
    }

    public Set<Payrollitems> getPayItems() {
        return payItems;
    }

    public void setPayItems(Set<Payrollitems> payItems) {
        this.payItems = payItems;
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
        final Payroll other = (Payroll) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.payrollID);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.baseSalary) ^ (Double.doubleToLongBits(this.baseSalary) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.totalPayroll) ^ (Double.doubleToLongBits(this.totalPayroll) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.payrollDate);
        hash = 67 * hash + Objects.hashCode(this.payItems);
        return hash;
    }

    @Override
    public boolean sameIdentityAs(Payroll other) {
        return this.equals(other);
    }
}
    



    
    

