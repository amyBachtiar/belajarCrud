package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author SAMSUNG
 */
public class RecruitmentPostDTO {
    
    private String recID; 
    private String recType;
    private boolean status;
    private String companyId;
   
    
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
