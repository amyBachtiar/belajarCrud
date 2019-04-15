package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Mega
 */
public class CompanyDTO {
    
    private String companyName;
    private String companyDesc;

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
    public CompanyDTO getInstance() {
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyName("Name");
        dto.setCompanyDesc("Description");
        return dto;
    }   
}