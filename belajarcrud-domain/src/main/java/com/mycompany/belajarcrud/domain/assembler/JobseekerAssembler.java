package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Jobseeker;
import com.mycompany.belajarcrud.dto.JobseekerDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JobseekerAssembler implements IObjectAssembler <Jobseeker, JobseekerDTO>{

    @Override
    public JobseekerDTO toDTO(Jobseeker domainObject) {
        JobseekerDTO dto = new JobseekerDTO();
        dto.setJobID(domainObject.getJobID());
        dto.setName(domainObject.getName());
        dto.setEducation(domainObject.getEducation());
        dto.setGpa(domainObject.getGpa());
        dto.setUniversity(domainObject.getUniversity());
        dto.setIntended_position(domainObject.getIntended_position());
        return dto;
    }

    @Override
    public Jobseeker toDomain(JobseekerDTO dto) {
        Jobseeker data = new Jobseeker();
        data.setJobID(dto.getJobID());
        data.setName(dto.getName());
        data.setEducation(dto.getEducation());
        data.setGpa(dto.getGpa());
        data.setUniversity(dto.getUniversity());
        data.setIntended_position(dto.getIntended_position());
        return data;
    }
    
    public List<JobseekerDTO> toDTOs(Set<Jobseeker> arg0) {
        List<JobseekerDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
     public List<JobseekerDTO> toDTOs(List<Jobseeker> arg0) {
        List<JobseekerDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
     
     public Set<Jobseeker> toDomains(List<JobseekerDTO> arg0) {
        Set<Jobseeker> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    } 
}