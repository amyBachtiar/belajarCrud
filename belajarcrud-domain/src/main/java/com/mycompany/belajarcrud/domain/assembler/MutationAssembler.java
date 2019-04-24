package com.mycompany.belajarcrud.domain.assembler;

/**
 *
 * @author tikaa 
 */
import com.eksad.dam.master.data.common.object.stereotype.IObjectAssembler;
import com.mycompany.belajarcrud.domain.Mutation;
import com.mycompany.belajarcrud.dto.MutationDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MutationAssembler implements IObjectAssembler<Mutation, MutationDTO>{
    @Override
	public MutationDTO toDTO(Mutation domainObject) {
		MutationDTO dto = new MutationDTO();
//		dto.setPosition(domainObject.getPosition());
		dto.setFinalPosition(domainObject.getFinalPosition());
		dto.setMutated(domainObject.isMutated());
		dto.setMutationNumber(domainObject.getMutationNumber());
		dto.setMutationDate(domainObject.getMutationDate());
                dto.setEmployeeDTOs(domainObject.getEmployees() != null ? new EmployeeAssembler().toDTOs(domainObject.getEmployees()): new ArrayList<>());
//		dto.setMutationBatch(domainObject.getMutationBatch());
		return dto;
	}

	@Override
	public Mutation toDomain(MutationDTO dto) {
		Mutation data = new Mutation();
		//data.setPosition(dto.getPosition());
		data.setFinalPosition(dto.getFinalPosition());
		data.setMutated(dto.isMutated());
		data.setMutationNumber(dto.getMutationNumber());
		data.setMutationDate(dto.getMutationDate());
		//data.setMutationBatch(dto.getMutationBatch());
                data.setEmployees(dto.getEmployeeDTOs()!= null ? new EmployeeAssembler().toDomains(dto.getEmployeeDTOs()): new HashSet<>());
		return data;
	}
	
	public List<MutationDTO> toDTOs(Set<Mutation> arg0) {
		List<MutationDTO> res = new ArrayList<>();
		arg0.stream().forEach((o) -> {
			res.add(toDTO(o));
		});
		return res;
	}
	
	public List<MutationDTO> toDTOs(List<Mutation> arg0) {
		List<MutationDTO> res = new ArrayList<>();
		arg0.stream().forEach((o) -> {
			res.add(toDTO(o));
		});
		return res;
	}
	
	public Set<Mutation> toDomains(List<MutationDTO> arg0) {
		Set<Mutation> res = new HashSet<>();	
		arg0.stream().forEach((o) -> {
			res.add(toDomain(o));
		});
		return res;
	}
}
