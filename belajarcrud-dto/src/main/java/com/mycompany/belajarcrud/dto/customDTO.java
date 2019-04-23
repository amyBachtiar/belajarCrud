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
    private String companyID;
    private JobdescDTO jobds;

    
    public customDTO() {
    }

    public customDTO(String payrollID, PayrollItemsDTO payrollIT, String companyID, JobdescDTO jobds) {
        this.payrollID = payrollID;
        this.payrollIT = payrollIT;
        this.companyID = companyID;
        this.jobds = jobds;
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

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public JobdescDTO getJobds() {
        return jobds;
    }

    public void setJobds(JobdescDTO jobds) {
        this.jobds = jobds;
    }
    
    
    
}
