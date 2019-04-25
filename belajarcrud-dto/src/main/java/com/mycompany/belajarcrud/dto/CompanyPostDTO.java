package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mega
 */
public class CompanyPostDTO {
    
    private String companyId;
    private String companyName;
    private String companyDesc;
  
    
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    // create data Employee dummy 
    @JsonIgnore
    public CompanyPostDTO getInstance() {
        CompanyPostDTO dto = new CompanyPostDTO();
        dto.setCompanyId("ID");
        dto.setCompanyName("Name");
        dto.setCompanyDesc("Description");
        return dto;
    }   
}
