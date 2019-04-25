package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public class RecruitmentPostDTO {
    
    private String recID; 
    private String recType;
    private boolean status;
    private List<JobseekerDTO>recJobs;
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

    public List<JobseekerDTO> getRecJobs() {
        return recJobs;
    }

    public void setRecJobs(List<JobseekerDTO> recJobs) {
        this.recJobs = recJobs;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    
    // create data dummy
    @JsonIgnore
    public RecruitmentPostDTO getInstance() {
        RecruitmentPostDTO dto = new RecruitmentPostDTO();
        dto.setRecID("Recruitment_ID : ");
        dto.setRecType("Recruitment_Type :");
        dto.setStatus(true);
        dto.setRecJobs(new ArrayList<>(Arrays.asList(new JobseekerDTO().getInstance())));
        dto.setCompanyId("Company_ID");
        return dto;
    }
    
}
