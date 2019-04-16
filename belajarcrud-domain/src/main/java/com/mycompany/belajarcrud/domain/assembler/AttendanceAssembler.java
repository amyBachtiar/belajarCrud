package com.mycompany.belajarcrud.domain.assembler;

import com.mycompany.belajarcrud.common.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Attendance;
import com.mycompany.belajarcrud.domain.Attendance;
import com.mycompany.belajarcrud.dto.AttendanceDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author amy
 */
public class AttendanceAssembler implements IObjectAssembler<Attendance, AttendanceDTO> {

    @Override
    public AttendanceDTO toDTO(Attendance domainObject) {
        AttendanceDTO dto = new AttendanceDTO();
        dto.setCode(domainObject.getCode());
        
        return dto;
    }

    @Override
    public Attendance toDomain(AttendanceDTO dto) {
        Attendance data = new Attendance();
        data.setCode(dto.getCode());
        return data;

    }

    public List<AttendanceDTO> toDTOs(Set<Attendance> arg0) {
        List<AttendanceDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }

    public List<AttendanceDTO> toDTOs(List<Attendance> arg0) {
        List<AttendanceDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
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
