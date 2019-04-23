
package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Payrollitems;
import com.mycompany.belajarcrud.dto.PayrollitemsDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Nadya
 */
public class PayrollitemsAssembler implements IObjectAssembler<Payrollitems, PayrollitemsDTO>{

    @Override
    public PayrollitemsDTO toDTO(Payrollitems domainObject){
        PayrollitemsDTO dto = new PayrollitemsDTO();
        dto.setPayrollitemsID(domainObject.getPayrollitemsID());
        dto.setPayrollitemsName(domainObject.getPayrollitemsName());
        dto.setPayrollitemsAmmount(domainObject.getPayrollitemsAmmount());
        dto.setPayrollDate(domainObject.getPayrollDate());
       
        return dto;
    }
    
    @Override
    public Payrollitems toDomain(PayrollitemsDTO dto){
        Payrollitems data = new Payrollitems();
        data.setPayrollitemsID(dto.getPayrollitemsID());
        data.setPayrollitemsName(dto.getPayrollitemsName());
        data.setPayrollitemsAmmount(dto.getPayrollitemsAmmount());
        data.setPayrollDate(dto.getPayrollDate());
        return data;
    }
    
    public List<PayrollitemsDTO> toDTOs(Set<Payrollitems>arg0){
        List<PayrollitemsDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public List<PayrollitemsDTO>toDTOs(List<Payrollitems>arg0){
        List<PayrollitemsDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public Set<Payrollitems> toDomains(List<PayrollitemsDTO>arg0){
        Set<Payrollitems> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));    
         });
        return res;
    }
}
