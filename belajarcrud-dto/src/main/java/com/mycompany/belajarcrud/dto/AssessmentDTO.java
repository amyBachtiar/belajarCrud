package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kori
 */
public class AssessmentDTO {
    private int empAssessment;
    private String empAssessID;
    private List <EmployeeDTO> employIdsDTOs;
    
    public AssessmentDTO(){
    }

    public AssessmentDTO(int empAssessment, String empAssessID, List<EmployeeDTO> employIdsDTOs) {
        this.empAssessment = empAssessment;
        this.empAssessID = empAssessID;
        this.employIdsDTOs = employIdsDTOs;
    }

    public int getEmpAssessment() {
        return empAssessment;
    }

    public void setEmpAssessment(int empAssessment) {
        this.empAssessment = empAssessment;
    }

    public String getEmpAssessID() {
        return empAssessID;
    }

    public void setEmpAssessID(String empAssessID) {
        this.empAssessID = empAssessID;
    }

    public List<EmployeeDTO> getEmployIdsDTOs() {
        return employIdsDTOs;
    }

    public void setEmployIdsDTOs(List<EmployeeDTO> employIdsDTOs) {
        this.employIdsDTOs = employIdsDTOs;
    }

      
 
    //create data dummy
    
    @JsonIgnore
    public AssessmentDTO getInstance(){
        AssessmentDTO dto=new AssessmentDTO();
        dto.setEmpAssessID("Employee Assessment ID");
        dto.setEmployIdsDTOs(new ArrayList<>(Arrays.asList(new EmployeeDTO().getInstance())));
        dto.setEmpAssessment(1000);
        return dto;
    }
}
