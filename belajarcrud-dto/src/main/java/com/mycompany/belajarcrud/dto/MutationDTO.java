package com.mycompany.belajarcrud.dto;

/**
 * 
 * @author tikaa
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MutationDTO {
	private String mutationNumber;	
        private String finalPosition;
	private boolean mutated;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
	private Date mutationDate;
        private List<EmployeeDTO> employeeDTOs;
        private String companyID;
	
	public MutationDTO() {
        }

    public MutationDTO(String mutationNumber, String finalPosition, boolean mutated, Date mutationDate, List<EmployeeDTO> employeeDTOs, String companyID) {
        this.mutationNumber = mutationNumber;
        this.finalPosition = finalPosition;
        this.mutated = mutated;
        this.mutationDate = mutationDate;
        this.employeeDTOs = employeeDTOs;
        this.companyID = companyID;
    }

    

//	public String getPosition() {
//		return position;
//	}
//	public void setPosition(String position) {
//		this.position = position;
//	}
	public String getFinalPosition() {
		return finalPosition;
	}
	public void setFinalPosition(String finalPosition) {
		this.finalPosition = finalPosition;
	}
	public boolean isMutated() {
		return mutated;
	}
	public void setMutated(boolean mutated) {
		this.mutated = mutated;
	}
	public String getMutationNumber() {
		return mutationNumber;
	}
	public void setMutationNumber(String mutationNumber) {
		this.mutationNumber = mutationNumber;
	}
	public Date getMutationDate() {
		return mutationDate;
	}
	public void setMutationDate(Date mutationDate) {
		this.mutationDate = mutationDate;
	}
//	public String getMutationBatch() {
//		return mutationBatch;
//	}
//	public void setMutationBatch(String mutationBatch) {
//		this.mutationBatch = mutationBatch;
//	}
        
        public List<EmployeeDTO> getEmployeeDTOs() {
            return employeeDTOs;
        }

        public void setEmployeeDTOs(List<EmployeeDTO> employeeDTOs) {
            this.employeeDTOs = employeeDTOs;
        }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
	
        
        
	//create data Employee dummy
	@JsonIgnore
	public MutationDTO getInstance() {
		MutationDTO dto = new MutationDTO();
                dto.setMutationNumber(UUID.randomUUID().toString().substring(0,6));
		//dto.setPosition("Masukkan Posisi");
                dto.setCompanyID(UUID.randomUUID().toString().substring(0, 6));
                dto.setFinalPosition("posisi akhir");
		dto.setMutated(true);
		Date mutdate = new Date();
		dto.setMutationDate(mutdate);
		//dto.setMutationBatch("Batch-01");
                dto.setEmployeeDTOs(new ArrayList<>(Arrays.asList(new EmployeeDTO().getInstance())));
		return dto;
	}
}
