/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Company;
import com.mycompany.belajarcrud.dto.CompanyDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
/**
 *
 * @author amel
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
        dto.setJobdescDTOs(domainObject.getJobdesc()!= null ? new JobdescAssembler().toDTOs(domainObject.getJobdesc()): new ArrayList<>());
        dto.setEmployeeDTOs(domainObject.getEmployees() != null ? new EmployeeAssembler().toDTOs(domainObject.getEmployees()): new ArrayList<>());
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
        data.setJobdesc(dto.getJobdescDTOs() != null ? new JobdescAssembler().toDomains(dto.getJobdescDTOs()): new HashSet<>());
        data.setEmployees(dto.getEmployeeDTOs()!= null ? new EmployeeAssembler().toDomains(dto.getEmployeeDTOs()): new HashSet<>());
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