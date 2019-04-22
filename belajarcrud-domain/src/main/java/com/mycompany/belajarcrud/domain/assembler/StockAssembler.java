package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Stock;
import com.mycompany.belajarcrud.dto.StockDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author amy
 */
public class StockAssembler implements IObjectAssembler<Stock, StockDTO> {

    @Override
    public StockDTO toDTO(Stock domainObject) {
        StockDTO dto = new StockDTO();
        dto.setCode(domainObject.getCode());
        dto.setPartCode(domainObject.getPart().getCode());
        dto.setQuantity(domainObject.getQuantity());
        dto.setStatus(domainObject.isStatus());
        return dto;
    }

    @Override
    public Stock toDomain(StockDTO dto) {
        Stock data = new Stock();
        data.setCode(dto.getCode());
        data.setQuantity(dto.getQuantity());
        data.setStatus(dto.isStatus());
        return data;

    }

    public List<StockDTO> toDTOs(Set<Stock> arg0) {
        List<StockDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public List<StockDTO> toDTOs(List<Stock> arg0) {
        List<StockDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public Set<Stock> toDomains(List<StockDTO> arg0) {
        Set<Stock> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }

}
