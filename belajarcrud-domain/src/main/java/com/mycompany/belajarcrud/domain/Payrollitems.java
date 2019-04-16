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
@Table(name = "MST_PayrollItems")
public class Payrollitems implements EntityObject<Payrollitems> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String payrollitemsID;
    private double bonusSalary;
    private double totalBonus;
    private double totalTax;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
    private Date payrollDate;
    
    public Payrollitems(){
    }

    public Payrollitems(String payrollitemsID, double bonusSalary, double totalBonus, double totalTax, Date payrollDate) {
        this.payrollitemsID = payrollitemsID;
        this.bonusSalary = bonusSalary;
        this.totalBonus = totalBonus;
        this.totalTax = totalTax;
        this.payrollDate = payrollDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayrollitemsID() {
        return payrollitemsID;
    }

    public void setPayrollitemsID(String payrollitemsID) {
        this.payrollitemsID = payrollitemsID;
    }

    public double getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(double bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public double getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(double totalBonus) {
        this.totalBonus = totalBonus;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
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
        final Payrollitems other = (Payrollitems) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.payrollitemsID);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.bonusSalary) ^ (Double.doubleToLongBits(this.bonusSalary) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.totalBonus) ^ (Double.doubleToLongBits(this.totalBonus) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.totalTax) ^ (Double.doubleToLongBits(this.totalTax) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.payrollDate);
        return hash;
    }

    
    @Override
    public boolean sameIdentityAs(Payrollitems other) {
        return this.equals(other);
    }
    
    
    
    
    
}
