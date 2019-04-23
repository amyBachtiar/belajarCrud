/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.assembler;
import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Bizpar;
import com.mycompany.belajarcrud.domain.CNBItem;
import com.mycompany.belajarcrud.dto.BizparDTO;
import com.mycompany.belajarcrud.dto.CNBItemDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author William
 */
public class CNBItemAssembler implements IObjectAssembler<CNBItem, CNBItemDTO> {
    @Override
    public CNBItemDTO toDTO(CNBItem domainObject) {
       CNBItemDTO dto = new CNBItemDTO();
        dto.setCnBempID(domainObject.getcnBempID());
        dto.setPensiun(domainObject.getPensiun());
        dto.setInsurance(domainObject.getInsurance());
        return dto;
    }

    @Override
    public CNBItem toDomain(CNBItemDTO dto) {
    CNBItem data = new CNBItem();
        data.setCnBempID(dto.getCnBempID());
//        data.setBaseSalary(dto.getBaseSalary());
        data.setPensiun(dto.getPensiun());
        data.setInsurance(dto.getInsurance());  
        return data;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<CNBItemDTO> toDTOs(Set<CNBItem> arg0) {
        List<CNBItemDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public List<CNBItemDTO> toDTOs(List<CNBItem> arg0) {
        List<CNBItemDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public Set<CNBItem> toDomains(List<CNBItemDTO> arg0) {
        Set<CNBItem> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }
}
