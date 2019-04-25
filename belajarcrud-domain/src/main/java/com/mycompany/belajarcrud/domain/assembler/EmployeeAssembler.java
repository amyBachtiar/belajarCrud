package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.CNB;
import com.mycompany.belajarcrud.domain.Employee;
import com.mycompany.belajarcrud.dto.CNBDTO;
import com.mycompany.belajarcrud.dto.EmployeeDTO;
import com.mycompany.belajarcrud.dto.EmployeePostDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 *
 * @author Mega
 */

public class EmployeeAssembler implements IObjectAssembler<Employee, EmployeeDTO> {
    
    @Override
    public EmployeeDTO toDTO(Employee domainObject){
        EmployeeDTO dto= new EmployeeDTO();
//        dto.setCompanyId(domainObject.getCompanyId());
        dto.setEmpId(domainObject.getEmpId());
        dto.setEmpName(domainObject.getEmpName());
        dto.setPosition(domainObject.getPosition());
        dto.setEmpStatus(domainObject.isEmpStatus());
        //dto.setEmpJobs(domainObject.getJobs()== null ? new ArrayList<>() : new JobdescAssembler().toDTOs(domainObject.getJobs()));
        dto.setBirthDate(domainObject.getBirthDate());
       // dto.setEmpAttendancesDTOs(domainObject.getEmpAttendances() != null ? new AttendanceAssembler().toDTOs(domainObject.getEmpAttendances()) : new ArrayList<>());
        dto.setCnbDTO(domainObject.getCnb() != null ? new CNBAssembler().toDTO(domainObject.getCnb()) : new CNBDTO());
        return dto;
    }
    
    @Override
    public Employee toDomain(EmployeeDTO dto){
        Employee data= new Employee();
        //data.setCompanyId(dto.getCompanyId());
        data.setEmpId(dto.getEmpId());
        data.setEmpName(dto.getEmpName());
        data.setPosition(dto.getPosition());
        data.setEmpStatus(dto.isEmpStatus());
        //data.setJobs(dto.getEmpJobs() == null ? new HashSet<>() : new JobdescAssembler().toDomains(dto.getEmpJobs()));
        data.setBirthDate(dto.getBirthDate());
        //data.setEmpAttendances(dto.getEmpAttendancesDTOs() != null ? new AttendanceAssembler().toDomains(dto.getEmpAttendancesDTOs()) : new HashSet<>());
//        data.setCnb(new CNB());
        return data;
    }
    
    public Employee toDomain(EmployeePostDTO dto){
        Employee data= new Employee();
        //data.setCompanyId(dto.getCompanyId());
        data.setEmpId(dto.getEmpId());
        data.setEmpName(dto.getEmpName());
        data.setPosition(dto.getPosition());
        data.setEmpStatus(dto.isEmpStatus());
        //data.setJobs(dto.getEmpJobs() == null ? new HashSet<>() : new JobdescAssembler().toDomains(dto.getEmpJobs()));
        data.setBirthDate(dto.getBirthDate());
        //data.setEmpAttendances(dto.getEmpAttendancesDTOs() != null ? new AttendanceAssembler().toDomains(dto.getEmpAttendancesDTOs()) : new HashSet<>());
//        data.setCnb(new CNB());
        return data;
    }
    public List<EmployeeDTO> toDTOs(Set<Employee> arg0) {
        List<EmployeeDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public List<EmployeeDTO> toDTOs(List<Employee> arg0) {
        List<EmployeeDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public Set<Employee> toDomains(List<EmployeeDTO> arg0) {
        Set<Employee> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }
}
