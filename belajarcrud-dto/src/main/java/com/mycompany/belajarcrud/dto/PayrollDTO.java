/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

/**
 *
 * @author DanielCABN
 */
public class PayrollDTO {
   private String payrollID;
	private double baseSalary;
	private double totalPayroll;
	
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone ="GMT+7")
	private Date payrollDate;

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
        
    //data dummy(contoh)
    @JsonIgnore
    public PayrollDTO getInstance(){
        PayrollDTO dto = new PayrollDTO();
        dto.setPayrollID("P001");
        dto.setBaseSalary(5000000);
        dto.setTotalPayroll(4500000);
        dto.setPayrollDate(payrollDate);
        return dto;
    }
	
}
