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
    private List<JobdescDTO> compJobsDTOs;
    private List<EmployeeDTO> listEmployeeDTOs;
    private List<MutationDTO> mutationDTOs;
    private List<RecruitmentPostDTO> recruitmentDTOs;

    public List<MutationDTO> getMutationDTOs() {
        return mutationDTOs;
    }

    public void setMutationDTOs(List<MutationDTO> mutationDTOs) {
        this.mutationDTOs = mutationDTOs;
    }
    
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

    public List<EmployeeDTO> getListEmployeeDTOs() {
        return listEmployeeDTOs;
    }

    public void setListEmployeeDTOs(List<EmployeeDTO> listEmployeeDTOs) {
        this.listEmployeeDTOs = listEmployeeDTOs;
    }

    public List<RecruitmentPostDTO> getRecruitmentDTOs() {
        return recruitmentDTOs;
    }

    public void setRecruitmentDTOs(List<RecruitmentPostDTO> recruitmentDTOs) {
        this.recruitmentDTOs = recruitmentDTOs;
    }
    
    

    // create data Employee dummy 
    @JsonIgnore
    public CompanyDTO getInstance() {
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyId("ID");
        dto.setCompanyName("Name");
        dto.setCompanyDesc("Description");
        return dto;
    }   
}
