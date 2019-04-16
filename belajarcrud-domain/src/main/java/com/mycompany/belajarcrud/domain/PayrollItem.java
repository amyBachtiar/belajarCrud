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
@Table(name = "MST_PAYROLL_ITEM")
public class PayrollItem implements EntityObject<PayrollItem>{



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	private String payrollItemID;
	private double bonusSalary;
	private double totalBonus;
	private double totalTax;
	
	
	private Date payrollItemDate;
	
	
	public PayrollItem() {
		
	}
	
	public PayrollItem (String payrollItemID,double bonusSalary, double totalBonus,double totalTax, Date payrollDate, Date payrollItemDate ) {
		this.payrollItemID= payrollItemID;
		this.bonusSalary = bonusSalary;
		this.totalBonus= totalBonus;
		this.payrollItemDate = payrollItemDate; 
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayrollItemsID() {
		return payrollItemID;
	}

	public void setPayrollItemsID(String payrollItemID) {
		this.payrollItemID = payrollItemID;
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
		return payrollItemDate;
	}

	public void setPayrollItemsDate(Date payrollItemsDate) {
		this.payrollItemDate = payrollItemDate;
	}


	@Override
	public boolean sameIdentityAs(PayrollItem other) {
		// TODO Auto-generated method stub
		return false;
	}

}
