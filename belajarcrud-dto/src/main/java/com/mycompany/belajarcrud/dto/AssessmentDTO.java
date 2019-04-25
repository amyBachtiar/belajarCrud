/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Addi jo
 */
public class AssessmentDTO {
 
    private String empAssessId;
    private int empAssessment;
    private String companyID;
    private List<EmployeeDTO> employeeDTOs;
    
    
    public AssessmentDTO(){
        
    }

    public AssessmentDTO(String empAssessId, int empAssessment, String companyID, List<EmployeeDTO> employeeDTOs) {
        this.empAssessId = empAssessId;
        this.empAssessment = empAssessment;
        this.companyID = companyID;
        this.employeeDTOs = employeeDTOs;
    }

    
    
    

    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeDTOs;
    }

    public void setEmployeeDTOs(List<EmployeeDTO> employeeDTOs) {
        this.employeeDTOs = employeeDTOs;
    }
      
    
    public String getEmpAssessId() {
        return empAssessId;
    }

    public void setEmpAssessId(String empAssessId) {
        this.empAssessId = empAssessId;
    }

    public int getEmpAssessment() {
        return empAssessment;
    }

    public void setEmpAssessment(int empAssessment) {
        this.empAssessment = empAssessment;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
    
    

    
    @JsonIgnore
    public AssessmentDTO getInstance(){
        AssessmentDTO dto= new AssessmentDTO();
        dto.setEmpAssessId("Employee Assessment ID");
        dto.setCompanyID(UUID.randomUUID().toString().substring(0, 6));
        dto.setEmployeeDTOs(new ArrayList<>(Arrays.asList(new EmployeeDTO().getInstance())));
        dto.setEmpAssessment(1000);
        return dto;
    }
    
}
