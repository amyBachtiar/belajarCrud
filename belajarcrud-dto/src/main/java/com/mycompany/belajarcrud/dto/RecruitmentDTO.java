package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

/**
 *
 * @author ilma
 */

public class RecruitmentDTO {
    
    private String recID; 
    private String companyID;
    private String recType;
    private boolean status;
    
    public RecruitmentDTO() {
    }

    public RecruitmentDTO(String recID, String companyID, String recType, boolean status) {
        this.recID = recID;
        this.companyID = companyID;
        this.recType = recType;
        this.status = status;
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

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
    

    
    // create data dummy
    @JsonIgnore
    public RecruitmentDTO getInstance() {
        RecruitmentDTO dto = new RecruitmentDTO();
        dto.setRecID("Recruitment_ID : ");
        dto.setCompanyID(UUID.randomUUID().toString().substring(0, 6));
        dto.setRecType("Recruitment_Type :");
        dto.setStatus(true);
        return dto;
    }
    
}