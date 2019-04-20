package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Mutation;
import com.mycompany.belajarcrud.dto.MutationDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MutationAssembler implements IObjectAssembler<Mutation, MutationDTO> {
    @Override
    public MutationDTO toDTO(Mutation domainObject) {
        MutationDTO dto = new MutationDTO();
        dto.setEmpID(domainObject.getEmpID());
        dto.setMutated(domainObject.isMutated());
        dto.setEmpName(domainObject.getEmpName());
        dto.setPosition(domainObject.getPosition());
        dto.setFinalPosition(domainObject.getFinalPosition());
        dto.setMutationDate(domainObject.getMutationDate());
        dto.setMutationNumber(domainObject.getMutationNumber());
      //  dto.setMutationBatch(domainObject.getMutationBatch());
//      dto.setEmpDTOs(domainObject.getMutationBatch() != null ? new EmployeeAssembler().toDTOs(domainObject.getMutationBatch()) : new ArrayList<>());
        return dto;
    }

    @Override
    public Mutation toDomain(MutationDTO dto) {
        Mutation data = new Mutation();
        data.setEmpID(dto.getEmpID());
        data.setEmpName(dto.getEmpName());
        data.setMutated(dto.isMutated());
        data.setPosition(dto.getPosition());
        data.setFinalPosition(dto.getFinalPosition());
        data.setMutationDate(dto.getMutationDate());
        data.setMutationNumber(dto.getMutationNumber());
     //   data.setMutationBatch(dto.getMutationBatch());
        return data;

    }

    public List<MutationDTO> toDTOs(Set<Mutation> arg0) {
        List<MutationDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public List<MutationDTO> toDTOs(List<Mutation> arg0) {
        List<MutationDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public Set<Mutation> toDomains(List<MutationDTO> arg0) {
        Set<Mutation> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }
}
