/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Addi jo
 */
public class AssessmentDTO {
 
    private String empAssessId;
    private int empAssessment;
    
    public AssessmentDTO(){
        
    }
    
    public AssessmentDTO(String empAssessId, int empAssessment){
        this.empAssessId = empAssessId;
        this.empAssessment = empAssessment;
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

    
    @JsonIgnore
    public AssessmentDTO getInstance(){
        AssessmentDTO dto= new AssessmentDTO();
        dto.setEmpAssessId("Employee Assessment ID");
        dto.setEmpAssessment(1000);
        return dto;
    }
    
}
