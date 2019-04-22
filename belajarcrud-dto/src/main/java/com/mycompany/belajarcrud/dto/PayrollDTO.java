/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DanielCABN
 */
public class PayrollDTO {
    private String payrollID;
    private double baseSalary;
    private double totalPayroll;
    private List<PayrollItemsDTO> payItems;
	
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone ="GMT+7")
	private Date payrollDate;

    public PayrollDTO() {
    }

        
    public PayrollDTO(String payrollID, double baseSalary, double totalPayroll, List<PayrollItemsDTO> payItems, Date payrollDate) {
        this.payrollID = payrollID;
        this.baseSalary = baseSalary;
        this.totalPayroll = totalPayroll;
        this.payItems = payItems;
        this.payrollDate = payrollDate;
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

    public List<PayrollItemsDTO> getPayItems() {
        return payItems;
    }

    public void setPayItems(List<PayrollItemsDTO> payItems) {
        this.payItems = payItems;
    }

   
    
    //data dummy(contoh)
    @JsonIgnore
    public PayrollDTO getInstance(){
        PayrollDTO dto = new PayrollDTO();
        dto.setPayrollID("P001");
        dto.setBaseSalary(5000000);
        dto.setTotalPayroll(4500000);
        dto.setPayrollDate(payrollDate);
        dto.setPayItems(new ArrayList<>(Arrays.asList(new PayrollItemsDTO().getInstance())));
        return dto;
    }
	
}
