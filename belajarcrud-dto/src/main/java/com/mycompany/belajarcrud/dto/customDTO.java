/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

/**
 *
 * @author eksad
 */
public class customDTO {
    private String payrollID;
    private PayrollItemsDTO payrollIT;

    public customDTO(String payrollID, PayrollItemsDTO payrollIT) {
        this.payrollID = payrollID;
        this.payrollIT = payrollIT;
    }

    public customDTO() {
    }
    

    public String getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(String payrollID) {
        this.payrollID = payrollID;
    }

    public PayrollItemsDTO getPayrollIT() {
        return payrollIT;
    }

    public void setPayrollIT(PayrollItemsDTO payrollIT) {
        this.payrollIT = payrollIT;
    }
    
    
}
