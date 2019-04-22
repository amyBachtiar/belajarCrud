package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

public class RecruitmentDTO {
    
    private String recID; 
    private String recType;
    private boolean status;
    private String jobjobID;
    
    public RecruitmentDTO() {
    }

    public RecruitmentDTO(String recID, String recType, boolean status, String jobjobID) {
        this.recID = recID;
        this.recType = recType;
        this.status = status;
        this.jobjobID = jobjobID;
    }

    public String getRecID() {
        return recID;
    }

    public void setRecID(String recID) {
        this.recID = recID;
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getJobjobID() {
        return jobjobID;
    }

    public void setJobjobID(String jobjobID) {
        this.jobjobID = jobjobID;
    }
    
    // create data dummy
    @JsonIgnore
    public RecruitmentDTO getInstance() {
        RecruitmentDTO dto = new RecruitmentDTO();
        dto.setRecID("Recruitment_ID : ");
        dto.setJobjobID("Jobseeker ID : ");
        dto.setRecType("Recruitment_Type :");
        dto.setStatus(true);
        return dto;
    }
    
}