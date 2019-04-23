/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author amelia
 */
public class CompanyDTO {
    
    private String companyID;
    private String companyName;
    private String companyAdd;
    private String companyPhone;
    private String companyDesc;
    private List<EmployeeDTO> employeeDTOs;
    private List<JobdescDTO> jobdescDTOs;
    private List<MutationDTO> mutationDTOs;
    private List<AssessmentDTO> assessmentDTOs;
    private List<RecruitmentDTO> recruitmentDTOs;

    public CompanyDTO() {
    }

    public CompanyDTO(String companyID, String companyName, String companyAdd, String companyPhone, String companyDesc, List<EmployeeDTO> employeeDTOs, List<JobdescDTO> jobdescDTOs, List<MutationDTO> mutationDTOs, List<AssessmentDTO> assessmentDTOs, List<RecruitmentDTO> recruitmentDTOs) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyAdd = companyAdd;
        this.companyPhone = companyPhone;
        this.companyDesc = companyDesc;
        this.employeeDTOs = employeeDTOs;
        this.jobdescDTOs = jobdescDTOs;
        this.mutationDTOs = mutationDTOs;
        this.assessmentDTOs = assessmentDTOs;
        this.recruitmentDTOs = recruitmentDTOs;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAdd() {
        return companyAdd;
    }

    public void setCompanyAdd(String companyAdd) {
        this.companyAdd = companyAdd;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeDTOs;
    }

    public void setEmployeeDTOs(List<EmployeeDTO> employeeDTOs) {
        this.employeeDTOs = employeeDTOs;
    }

    public List<JobdescDTO> getJobdescDTOs() {
        return jobdescDTOs;
    }

    public void setJobdescDTOs(List<JobdescDTO> jobdescDTOs) {
        this.jobdescDTOs = jobdescDTOs;
    }

    public List<MutationDTO> getMutationDTOs() {
        return mutationDTOs;
    }

    public void setMutationDTOs(List<MutationDTO> mutationDTOs) {
        this.mutationDTOs = mutationDTOs;
    }

    public List<AssessmentDTO> getAssessmentDTOs() {
        return assessmentDTOs;
    }

    public void setAssessmentDTOs(List<AssessmentDTO> assessmentDTOs) {
        this.assessmentDTOs = assessmentDTOs;
    }

    public List<RecruitmentDTO> getRecruitmentDTOs() {
        return recruitmentDTOs;
    }

    public void setRecruitmentDTOs(List<RecruitmentDTO> recruitmentDTOs) {
        this.recruitmentDTOs = recruitmentDTOs;
    }
    
    
    //dummy
    @JsonIgnore
    public CompanyDTO getInstance(){
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyID(UUID.randomUUID().toString().substring(0,6));
        dto.setCompanyName("eksad");
        dto.setCompanyAdd("Bandung");
        dto.setCompanyPhone("022-123456");
        dto.setCompanyDesc("it comp");
        dto.setEmployeeDTOs(new ArrayList<>(Arrays.asList(new EmployeeDTO().getInstance())));
        dto.setJobdescDTOs(new ArrayList<>(Arrays.asList(new JobdescDTO().getInstance())));
        dto.setMutationDTOs(new ArrayList<>(Arrays.asList(new MutationDTO().getInstance())));
        dto.setAssessmentDTOs(new ArrayList<>(Arrays.asList(new AssessmentDTO().getInstance())));
        dto.setRecruitmentDTOs(new ArrayList<>(Arrays.asList(new RecruitmentDTO().getInstance())));
        return dto;
    }
}
