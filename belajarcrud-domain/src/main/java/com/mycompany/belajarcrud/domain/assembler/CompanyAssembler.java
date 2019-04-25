/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Company;
import com.mycompany.belajarcrud.dto.CompanyDTO;
import com.mycompany.belajarcrud.dto.CompanySinglePostDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
/**
 *
 * @author amelia
 */
public class CompanyAssembler implements IObjectAssembler<Company, CompanyDTO>{

    @Override
    public CompanyDTO toDTO(Company domainObject) {
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyID(domainObject.getCompanyID());
        dto.setCompanyName(domainObject.getCompanyName());
        dto.setCompanyAdd(domainObject.getCompanyAdd());
        dto.setCompanyPhone(domainObject.getCompanyPhone());
        dto.setCompanyDesc(domainObject.getCompanyDesc());
        dto.setEmployeeDTOs(domainObject.getEmployees() !=null ? new EmployeeAssembler().toDTOs(domainObject.getEmployees()): new ArrayList<>());
        dto.setJobdescDTOs(domainObject.getJobdescs()!=null ? new JobdescAssembler().toDTOs(domainObject.getJobdescs()): new ArrayList<>());
        dto.setMutationDTOs(domainObject.getMutations() != null ? new MutationAssembler().toDTOs(domainObject.getMutations()) : new ArrayList<>());
        dto.setRecruitmentDTOs(domainObject.getRecruitments() != null ? new RecruitmentAssembler().toDTOs(domainObject.getRecruitments()) : new ArrayList<>());
        dto.setAssessmentDTOs(domainObject.getAssesment() != null ? new AssessmentAssembler().toDTOs(domainObject.getAssesment()) : new ArrayList<>());
        return dto;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company toDomain(CompanyDTO dto) {
        Company data = new Company();
        data.setCompanyID(dto.getCompanyID());
        data.setCompanyName(dto.getCompanyName());
        data.setCompanyAdd(dto.getCompanyAdd());
        data.setCompanyPhone(dto.getCompanyPhone());
        data.setCompanyDesc(dto.getCompanyDesc());
        return data;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Company toDomain(CompanySinglePostDTO SPdto) {
        Company data = new Company();
        data.setCompanyID(SPdto.getCompanyID());
        data.setCompanyName(SPdto.getCompanyName());
        data.setCompanyAdd(SPdto.getCompanyAdd());
        data.setCompanyPhone(SPdto.getCompanyPhone());
        data.setCompanyDesc(SPdto.getCompanyDesc());
        return data;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<CompanyDTO> toDTOs(Set<Company>arg0){
        List<CompanyDTO> res = new ArrayList<>();
        arg0.stream().forEach((o)->{
            res.add(toDTO(o));
        });
        return res;
    }
    
    public List<CompanyDTO> toDTOs(List<Company> arg0) {
        List<CompanyDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public Set<Company> toDomains(List<CompanyDTO> arg0) {
        Set<Company> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }
}