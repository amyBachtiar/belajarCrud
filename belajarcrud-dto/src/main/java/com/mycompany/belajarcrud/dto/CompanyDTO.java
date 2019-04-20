package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mega
 */
public class CompanyDTO {
    
    private String companyId;
    private String companyName;
    private String companyDesc;
    private List<JobdescDTO>compJobsDTOs;
    

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

    public List<JobdescDTO> getCompJobsDTOs() {
        return compJobsDTOs;
    }

    public void setCompJobsDTOs(List<JobdescDTO> compJobsDTOs) {
        this.compJobsDTOs = compJobsDTOs;
    }
    
    
    // create data Employee dummy 
    @JsonIgnore
    public CompanyDTO getInstance() {
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyId("ID");
        dto.setCompanyName("Name");
        dto.setCompanyDesc("Description");
//        dto.setMutationDTOs(new ArrayList<>(Arrays.asList(new MutationDTO().getInstance())));
        dto.setCompJobsDTOs(new ArrayList<>(Arrays.asList(new JobdescDTO().getInstance())));
        return dto;
    }   
}
