/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Payroll;
import com.mycompany.belajarcrud.dto.PayrollDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author DanielCABN
 */
public class PayrollAssembler implements IObjectAssembler<Payroll, PayrollDTO>{

    @Override
    public PayrollDTO toDTO(Payroll domainObject) {
        PayrollDTO dto = new PayrollDTO();
        dto.setPayrollID(domainObject.getPayrollID());
        dto.setBaseSalary(domainObject.getBaseSalary());
        dto.setTotalPayroll(domainObject.getTotalPayroll());
        dto.setPayrollDate(domainObject.getPayrollDate());
        return dto;
    }

    @Override
    public Payroll toDomain(PayrollDTO dto) {
      Payroll data = new Payroll();
      data.setPayrollID(dto.getPayrollID());
      data.setBaseSalary(dto.getBaseSalary());
      data.setTotalPayroll(dto.getTotalPayroll());
      data.setPayrollDate(dto.getPayrollDate());
      return data;
     }
    
    public List <PayrollDTO> toDTO (Set<Payroll>arg0){
        List <PayrollDTO> res = new ArrayList<>();
        arg0.stream().forEach((o)->{
        res.add(toDTO(o));
    });
    return res;
    }
    
    public Set <Payroll> toDomain (List<PayrollDTO> arg0){
        Set<Payroll> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
        res.add(toDomain(o));
    });
    return res;
    }
    
}
