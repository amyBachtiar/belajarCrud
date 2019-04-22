/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Assessment;
import com.mycompany.belajarcrud.dto.AssessmentDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Addi
 */
public class AssessmentAssembler implements IObjectAssembler<Assessment,AssessmentDTO>{
    
    @Override
    public AssessmentDTO toDTO(Assessment domainObject) {
        AssessmentDTO dto = new AssessmentDTO();
        dto.setEmpAssessID(domainObject.getEmpAssessId());
      //dto.setEmployeeID(domainObject.getEmpIDs().getEmpID());
        dto.setEmpAssessment(domainObject.getEmpAssessment());
        return dto;
    }
    
    @Override
    public Assessment toDomain(AssessmentDTO domainObject) {
        Assessment data = new Assessment();
        data.setEmpAssessId(domainObject.getEmpAssessID());
        data.setEmpAssessment(domainObject.getEmpAssessment());
        return data;
    }
    
    public List<AssessmentDTO> toDTOs(Set<Assessment> arg0) {
        List<AssessmentDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public List<AssessmentDTO> toDTOs(List<Assessment> arg0) {
        List<AssessmentDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public Set<Assessment> toDomains(List<AssessmentDTO> arg0) {
        Set<Assessment> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }
    
}