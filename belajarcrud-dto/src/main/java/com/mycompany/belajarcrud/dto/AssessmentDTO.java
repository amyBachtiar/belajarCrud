/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Addi
 */
public class AssessmentDTO {
 
    private String empAssessID;
    private int empAssessment;
    
    public AssessmentDTO(){
        
    }
    
    public AssessmentDTO(String empAssessID, int empAssessment){
        this.empAssessID = empAssessID;
        this.empAssessment = empAssessment;
    }

    public String getEmpAssessID() {
        return empAssessID;
    }

    public void setEmpAssessID(String empAssessID) {
        this.empAssessID = empAssessID;
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
        dto.setEmpAssessID("Employee Assessment ID");
        dto.setEmpAssessment(1000);
        return dto;
    }
    
}
