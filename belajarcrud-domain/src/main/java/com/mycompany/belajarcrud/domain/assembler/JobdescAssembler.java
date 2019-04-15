
package com.mycompany.belajarcrud.domain.assembler;

import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Jobdesc;
import com.mycompany.belajarcrud.dto.JobdescDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Reza Agika Putra
 */
public class JobdescAssembler implements IObjectAssembler<Jobdesc, JobdescDTO>{

    @Override
    public JobdescDTO toDTO(Jobdesc domainObject) {
        JobdescDTO dto = new JobdescDTO();
        dto.setJobdescId(domainObject.getJobdescId());
        dto.setName(domainObject.getName());
        dto.setDescription(domainObject.getDescription());
        return dto;
    }

    @Override
    public Jobdesc toDomain(JobdescDTO dto) {
        Jobdesc data = new Jobdesc();
        data.setJobdescId(dto.getJobdescId());
        data.setName(dto.getName());
        data.setDescription(dto.getDescription());
        return data;
    }
    
    public List<JobdescDTO> toDTOs(Set<Jobdesc> arg0){
        List<JobdescDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public List<JobdescDTO> toDTOs(List<Jobdesc> arg0){
        List<JobdescDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public Set<Jobdesc> toDomains(List<JobdescDTO> arg0){
        Set<Jobdesc> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }
}
