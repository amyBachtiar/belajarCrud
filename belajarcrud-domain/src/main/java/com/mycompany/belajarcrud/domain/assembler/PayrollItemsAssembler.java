/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;

import com.mycompany.belajarcrud.domain.PayrollItems;

import com.mycompany.belajarcrud.dto.PayrollItemsDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author DanielCABN
 */
public class PayrollItemsAssembler implements IObjectAssembler<PayrollItems, PayrollItemsDTO>{
    @Override
    public PayrollItemsDTO toDTO (PayrollItems domainObject){
        PayrollItemsDTO dto = new PayrollItemsDTO();
        dto.setPayrollItemsID(domainObject.getPayrollItemsID());
        dto.setPayrollID(domainObject.getPayrollID());
        dto.setBonusSalary(domainObject.getBonusSalary());
        dto.setTotalBonus(domainObject.getTotalBonus());
        dto.setTotalTax(domainObject.getTotalTax());
        dto.setPayrollItemsDate(domainObject.getPayrollItemsDate());
        return dto;
        
    }
    
      @Override
    public PayrollItems toDomain (PayrollItemsDTO dto){
        PayrollItems data = new PayrollItems();
        data.setPayrollItemsID(dto.getPayrollItemsID());
        data.setPayrollID(dto.getPayrollID());
        data.setBonusSalary(dto.getBonusSalary());
        data.setTotalBonus(dto.getTotalBonus());
        data.setTotalTax(dto.getTotalTax());
        data.setPayrollItemsDate(dto.getPayrollItemsDate());
        return data;
   
    }
    public List<PayrollItemsDTO> toDTOs(Set<PayrollItems>arg0){
        List<PayrollItemsDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
     public List<PayrollItemsDTO>toDTOs(List<PayrollItems>arg0){
        List<PayrollItemsDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
}
    public Set<PayrollItems> toDomains(List<PayrollItemsDTO>arg0){
        Set<PayrollItems> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));    
         });
        return res;
}
}