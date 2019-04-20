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
 * @author Mega
 */
public class CompanyAssembler implements IObjectAssembler<Company, CompanyDTO>{
    @Override
    public CompanyDTO toDTO(Company domainObject){
        CompanyDTO dto= new CompanyDTO();
        dto.setCompanyId(domainObject.getCompanyId());
        dto.setCompanyName(domainObject.getCompanyName());
        dto.setCompanyDesc(domainObject.getCompanyDesc());
        //dto.setMutationDTOs(domainObject.getMutations() != null ? new MutationAssembler().toDTOs(domainObject.getMutations()): new ArrayList<>());
        return dto;
    }
    
    @Override
    public Company toDomain(CompanyDTO dto){
        Company data= new Company();
        data.setCompanyId(dto.getCompanyId());
        data.setCompanyName(dto.getCompanyName());
        data.setCompanyDesc(dto.getCompanyDesc());
        //data.setMutations(dto.getMutationDTOs() != null ? new MutationAssembler().toDomains(dto.getMutationDTOs()): new HashSet<>());
        return data;
    }
    
    public List<CompanyDTO> toDTOs(Set<Company> arg0) {
        List<CompanyDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
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
