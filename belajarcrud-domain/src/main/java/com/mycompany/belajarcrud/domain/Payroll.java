package com.mycompany.belajarcrud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    
    
    private String payrollID;
    private double baseSalary;
    private double totalPayroll;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
    private Date payrollDate;

    public Payroll() {
    }

    public Payroll( String payrollID, double baseSalary, double totalPayroll, Date payrollDate) {
        this.payrollID = payrollID;
        this.baseSalary = baseSalary;
        this.totalPayroll = totalPayroll;
        this.payrollDate = payrollDate;
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
        hash = 97 * hash + Objects.hashCode(this.payrollID);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.baseSalary) ^ (Double.doubleToLongBits(this.baseSalary) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.totalPayroll) ^ (Double.doubleToLongBits(this.totalPayroll) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.payrollDate);
        return hash;
    }

    @Override
    public boolean sameIdentityAs(Payroll other) {
        return this.equals(other);
    }
}
    



    
    
