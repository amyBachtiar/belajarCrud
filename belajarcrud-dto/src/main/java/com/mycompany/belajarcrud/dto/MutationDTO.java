package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MutationDTO {
    private String empID;
    private String empName;
    private String position;
    private String finalPosition;
    private boolean mutated;
    private String mutationNumber;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date mutationDate;
    private String companyId;
//    private String mutationBatch;
//    private List<EmployeeDTO> empDTOs;
    
    public MutationDTO() {
    }

    public MutationDTO(String empID, String empName, String position, String finalPosition, boolean mutated,List<EmployeeDTO> empDTOs,String mutationNumber, Date mutationDate) {
        this.empID = empID;
        this.empName = empName;
        this.position = position;
        this.finalPosition = finalPosition;
        this.mutated = mutated;
//        this.empDTOs=empDTOs;
        this.mutationNumber = mutationNumber;
        this.mutationDate = mutationDate;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    
    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(String finalPosition) {
        this.finalPosition = finalPosition;
    }

    public boolean isMutated() {
        return mutated;
    }

    public void setMutated(boolean mutated) {
        this.mutated = mutated;
    }

    public String getMutationNumber() {
        return mutationNumber;
    }

    public void setMutationNumber(String mutationNumber) {
        this.mutationNumber = mutationNumber;
    }

    public Date getMutationDate() {
        return mutationDate;
    }

    public void setMutationDate(Date mutationDate) {
        this.mutationDate = mutationDate;
    }

//    public String getMutationBatch() {
//        return mutationBatch;
//    }
//
//    public void setMutationBatch(String mutationBatch) {
//        this.mutationBatch = mutationBatch;
//    }
    
    // create data Employee dummy 
    @JsonIgnore
    public MutationDTO getInstance() {
        MutationDTO dto = new MutationDTO();
        dto.setEmpID("ID-001");
        dto.setEmpName("Masukkan Nama");
        dto.setPosition("Masukkan Posisi");
        dto.setMutated(true);
        Date mutdate=new Date();
        dto.setMutationDate(mutdate);
//        dto.setMutationBatch("Batch-01");
        dto.setMutationNumber("MX-100031");
//        dto.setEmpDTOs(new ArrayList<>(Arrays.asList(new EmployeeDTO().getInstance())));
        return dto;
    }
}
