/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.assembler;

import com.mycompany.belajarcrud.common.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Employee;
import com.mycompany.belajarcrud.dto.EmployeeDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author eksad
 */
public class EmployeeAssembler implements IObjectAssembler<Employee, EmployeeDTO>{

    @Override
    public EmployeeDTO toDTO(Employee domainObject) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmpId(domainObject.getEmpId());
        dto.setEmpName(domainObject.getEmpName());
        dto.setPosition(domainObject.getPosition());
        dto.setEmpStatus(domainObject.isEmpStatus());
        dto.setBirthDate(domainObject.getBirthDate());
        return dto;
    }

    @Override
    public Employee toDomain(EmployeeDTO dto) {
        Employee data = new Employee();
        data.setEmpId(dto.getEmpId());
        data.setEmpName(dto.getEmpName());
        data.setPosition(dto.getPosition());
        data.setEmpStatus(dto.isEmpStatus());
        data.setBirthDate(dto.getBirthDate());
        return data;
        
    }
    
    public List<EmployeeDTO> toDTOs(Set<Employee> arg0){
        List<EmployeeDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public List<EmployeeDTO> toDTOs(List<Employee> arg0){
        List<EmployeeDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
    });
        return res;
    }
    
    public Set<Employee> toDomains(List<EmployeeDTO> arg0){
        Set<Employee> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
        }
    }