package com.mycompany.belajarcrud.domain.assembler;

import com.mycompany.belajarcrud.common.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Bizpar;
import com.mycompany.belajarcrud.dto.BizparDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author amy
 */
public class BizparAssembler implements IObjectAssembler<Bizpar, BizparDTO> {

    @Override
    public BizparDTO toDTO(Bizpar domainObject) {
        BizparDTO dto = new BizparDTO();
        dto.setKey(domainObject.getKey());
        dto.setStatus(domainObject.isStatus());
        dto.setValue(domainObject.getValue());
        return dto;
    }

    @Override
    public Bizpar toDomain(BizparDTO dto) {
        Bizpar data = new Bizpar();
        data.setKey(dto.getKey());
        data.setValue(dto.getValue());
        data.setStatus(dto.getStatus());
        return data;

    }

    public List<BizparDTO> toDTOs(Set<Bizpar> arg0) {
        List<BizparDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public List<BizparDTO> toDTOs(List<Bizpar> arg0) {
        List<BizparDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public Set<Bizpar> toDomains(List<BizparDTO> arg0) {
        Set<Bizpar> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }

}
