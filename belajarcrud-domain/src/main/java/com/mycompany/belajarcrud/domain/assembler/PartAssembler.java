package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Part;
import com.mycompany.belajarcrud.dto.PartDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author amy
 */
public class PartAssembler implements IObjectAssembler<Part, PartDTO> {

    @Override
    public PartDTO toDTO(Part domainObject) {
        PartDTO dto = new PartDTO();
        dto.setCode(domainObject.getCode());
        dto.setStatus(domainObject.isStatus());
        dto.setDescription(domainObject.getDescription());
        return dto;
    }

    @Override
    public Part toDomain(PartDTO dto) {
        Part data = new Part();
        data.setCode(dto.getCode());
        data.setStatus(dto.isStatus());
        data.setDescription(dto.getDescription());
        return data;

    }

    public List<PartDTO> toDTOs(Set<Part> arg0) {
        List<PartDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public List<PartDTO> toDTOs(List<Part> arg0) {
        List<PartDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public Set<Part> toDomains(List<PartDTO> arg0) {
        Set<Part> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }

}
