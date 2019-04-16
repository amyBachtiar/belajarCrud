package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

/**
 *
 * @author SAMSUNG
 */
public class RecruitmentDTO {
    private String recID; 
    private String recType;
    private boolean status;

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

    
    // create data dummy
    @JsonIgnore
    public RecruitmentDTO getInstance() {
        RecruitmentDTO dto = new RecruitmentDTO();
        dto.setRecID("Recruitment_ID : ");
        dto.setRecType("Recruitment_Type :");
        dto.setStatus(true);
        return dto;
    }
    
}
