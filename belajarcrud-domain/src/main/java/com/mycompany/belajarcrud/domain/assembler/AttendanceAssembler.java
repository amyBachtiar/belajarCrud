/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Attendance;
import com.mycompany.belajarcrud.dto.AttendanceDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
/**
 *
 * @author noldyy
 */
public class AttendanceAssembler implements IObjectAssembler<Attendance, AttendanceDTO>{

    @Override
    public AttendanceDTO toDTO(Attendance domainObject) {
        AttendanceDTO dto = new AttendanceDTO();
        dto.setCode(domainObject.getCode());
        dto.setDate(domainObject.getDate());
        dto.setTimeIn(domainObject.getTimeIn());
        dto.setTimeOut(domainObject.getTimeOut());
        return dto;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Attendance toDomain(AttendanceDTO dto) {
        Attendance data = new Attendance();
        data.setCode(dto.getCode());
        data.setDate(dto.getDate());
        data.setTimeIn(dto.getTimeIn());
        data.setTimeOut(dto.getTimeOut());
        return data;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<AttendanceDTO> toDTOs(Set<Attendance>arg0){
        List<AttendanceDTO> res = new ArrayList<>();
        arg0.stream().forEach((o)->{
            res.add(toDTO(o));
        });
        return res;
    }


    public Set<Attendance> toDomains(List<AttendanceDTO> arg0) {
        Set<Attendance> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
}
}