/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.assembler.CNBItemAssembler;
import com.mycompany.belajarcrud.domain.CNB;
import com.mycompany.belajarcrud.dto.CNBDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author eksad-edwina
 */
public class CNBAssembler implements IObjectAssembler<CNB, CNBDTO>{

    @Override
    public CNBDTO toDTO(CNB domainObject) {
       CNBDTO dto = new CNBDTO();
       dto.setEmpName(domainObject.getEmpName());
        dto.setEmpID(domainObject.getEmpID());
        dto.setSalary(new PayrollAssembler().toDTO(domainObject.getSalary()));
        dto.setCnbItemsDTOs(domainObject.getCnbItems()!= null?
                new CNBItemAssembler().toDTOs(domainObject.getCnbItems())
                        : new ArrayList<>());
        return dto;
    }

    @Override
    public CNB toDomain(CNBDTO dto) {
    CNB data = new CNB();
        data.setEmpID(dto.getEmpID());
        data.setEmpName(dto.getEmpName());
        data.setSalary(new PayrollAssembler().toDomain(dto.getSalary()));
        data.setCnbItems(dto.getCnbItemsDTOs()!= null?
            new CNBItemAssembler().toDomains(dto.getCnbItemsDTOs()):
                new HashSet<>());
        return data;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<CNBDTO> toDTOs(Set<CNB> arg0) {
        List<CNBDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public List<CNBDTO> toDTOs(List<CNB> arg0) {
        List<CNBDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public Set<CNB> toDomains(List<CNBDTO> arg0) {
        Set<CNB> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }

    
}