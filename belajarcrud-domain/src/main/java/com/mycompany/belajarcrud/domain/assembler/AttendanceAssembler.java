
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
 * @author Reza Agika Putra
 */
public class AttendanceAssembler implements IObjectAssembler<Attendance, AttendanceDTO>{  
    @Override
    public AttendanceDTO toDTO(Attendance domainObject){
        AttendanceDTO dto = new AttendanceDTO();
        dto.setDate(domainObject.getDate());
        dto.setEmpId(domainObject.getEmpId());
        dto.setAttendanceId(domainObject.getAttendanceId());
        dto.setTimeIn(domainObject.getTimeIn());
        dto.setTimeOut(domainObject.getTimeOut());
        return dto;
    }

    @Override
    public Attendance toDomain(AttendanceDTO dto) {
        Attendance data = new Attendance();
        data.setDate(dto.getDate());
        data.setEmpId(dto.getEmpId());
        data.setAttendanceId(dto.getAttendanceId());
        data.setTimeIn(dto.getTimeIn());
        data.setTimeOut(dto.getTimeOut());
        return data;
    }
    
    public List<AttendanceDTO> toDTOs(Set<Attendance> arg0){
        List<AttendanceDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public List<AttendanceDTO> toDTOs(List<Attendance> arg0){
        List<AttendanceDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public Set<Attendance> toDomains(List<AttendanceDTO> arg0){
        Set<Attendance> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }
}