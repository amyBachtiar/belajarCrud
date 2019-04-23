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
public class PayrollItemsDTO {
    private String payrollItemsID; 
    private String payrollID;
	private double bonusSalary;
	private double totalBonus;
	private double totalTax;
        
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone ="GMT+7")
	private Date payrollItemsDate;



        
    public String getPayrollItemsID() {
        return payrollItemsID;
    }

    public void setPayrollItemsID(String payrollItemsID) {
        this.payrollItemsID = payrollItemsID;
    }

    public String getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(String payrollID) {
        this.payrollID = payrollID;
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

    
    
        
    //create data dummy
    @JsonIgnore
    public PayrollItemsDTO getInstance(){
        PayrollItemsDTO dto = new PayrollItemsDTO();
        dto.setPayrollItemsID("PI001");
//        dto.setPayrollID("P001");
        dto.setBonusSalary(1000000);
        dto.setTotalBonus(1500000);
        dto.setTotalTax(500000);
        dto.setPayrollItemsDate(payrollItemsDate);
        return dto; 
        
    }
        
}
