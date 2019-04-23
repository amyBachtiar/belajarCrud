package com.mycompany.belajarcrud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mycompany.belajarcrud.common.EntityObject;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author Daniel
*/
@Entity
@Table(name = "MST_PAYROLL_ITEMS")
public class PayrollItems implements EntityObject<PayrollItems>{



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	private String payrollItemsID;
        //private String payrollID;
	private double bonusSalary;
	private double totalBonus;
	private double totalTax;
	
	 @Temporal(TemporalType.DATE)
	private Date payrollItemsDate;
	
	
	public PayrollItems() {
		
	}

    public PayrollItems(String payrollItemsID, double bonusSalary, double totalBonus, double totalTax, Date payrollItemsDate) {
  
        this.payrollItemsID = payrollItemsID;
      
        this.bonusSalary = bonusSalary;
        this.totalBonus = totalBonus;
        this.totalTax = totalTax;
        this.payrollItemsDate = payrollItemsDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayrollItemsID() {
        return payrollItemsID;
    }

    public void setPayrollItemsID(String payrollItemsID) {
        this.payrollItemsID = payrollItemsID;
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

    public Date getPayrollItemsDate() {
        return payrollItemsDate;
    }

    public void setPayrollItemsDate(Date payrollItemsDate) {
        this.payrollItemsDate = payrollItemsDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.payrollItemsID);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.bonusSalary) ^ (Double.doubleToLongBits(this.bonusSalary) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.totalBonus) ^ (Double.doubleToLongBits(this.totalBonus) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.totalTax) ^ (Double.doubleToLongBits(this.totalTax) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.payrollItemsDate);
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
        final PayrollItems other = (PayrollItems) obj;
        return true;
    }
	
	



	@Override
	public boolean sameIdentityAs(PayrollItems other) {
		// TODO Auto-generated method stub
		return false;
	}

}