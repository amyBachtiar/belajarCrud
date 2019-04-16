package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author kori
 */
public class AssessmentDTO {
    private int empAssessment;
    private String empAssessID;
    //private String employeeID;
    
    public AssessmentDTO(){
    }

    public AssessmentDTO(int empAssessment, String empAssessID/*, String employeeID*/) {
        this.empAssessment = empAssessment;
        this.empAssessID = empAssessID;
       // this.employeeID = employeeID;
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

    /*
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }*/

 
    //create data dummy
    
    @JsonIgnore
    public AssessmentDTO getInstance(){
        AssessmentDTO dto=new AssessmentDTO();
        dto.setEmpAssessID("Employee Assessment ID");
       // dto.setEmployeeID("Employee ID");
        dto.setEmpAssessment(1000);
        return dto;
    }
}
