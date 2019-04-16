package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Recruitment;
import com.mycompany.belajarcrud.dto.RecruitmentDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author SAMSUNG
 */
public class RecruitmentAssembler implements IObjectAssembler <Recruitment, RecruitmentDTO>{
    
  @Override
    public RecruitmentDTO toDTO(Recruitment domainObject) {
        RecruitmentDTO dto = new RecruitmentDTO();
        dto.setRecID(domainObject.getRecID());
        dto.setRecType(domainObject.getRecType());
        dto.setStatus(domainObject.isStatus());
        return dto;
    }  
    
    @Override
    public Recruitment toDomain(RecruitmentDTO dto) {
        Recruitment data = new Recruitment();
        data.setRecID(dto.getRecID());
        data.setRecType(dto.getRecType());
        data.setStatus(dto.getStatus());
        return data;
    }
    
    public List<RecruitmentDTO> toDTOs(Set<Recruitment> arg0) {
        List<RecruitmentDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public List<RecruitmentDTO> toDTOs(List<Recruitment> arg0) {
        List<RecruitmentDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public Set<Recruitment> toDomains(List<RecruitmentDTO> arg0) {
        Set<Recruitment> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }

}
