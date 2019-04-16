package com.mycompany.belajarcrud.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mycompany.belajarcrud.common.EntityObject;

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
	private double bonusSalary;
	private double totalBonus;
	private double totalTax;
	
	
	private Date payrollItemsDate;
	
	
	public PayrollItems() {
		
	}
	
	public PayrollItems (String payrollItemsID,double bonusSalary, double totalBonus,double totalTax, Date payrollDate, Date payrollItemsDate ) {
		this.payrollItemsID= payrollItemsID;
		this.bonusSalary = bonusSalary;
		this.totalBonus= totalBonus;
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
	public boolean sameIdentityAs(PayrollItems other) {
		// TODO Auto-generated method stub
		return false;
	}

}
