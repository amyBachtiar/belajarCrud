package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
