package com.mycompany.belajarcrud.domain;

import java.util.Date;

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
@Table(name = "MST_PAYROLL")
public class Payroll implements EntityObject<Payroll> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	private String payrollID;
	private double baseSalary;
	private double totalPayroll;
	
	private Date payrollDate;
	
	public Payroll() {
		
	}
	
	public Payroll (String payrollID,double baseSalary, double totalPayroll, Date payrollDate ) {
		this.payrollID = payrollID;
		this.baseSalary = baseSalary;
		this.totalPayroll= totalPayroll;
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


	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Payroll other = (Payroll) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}

	@Override
	public boolean sameIdentityAs(Payroll other) {
		// TODO Auto-generated method stub
		return false;
	}

}
