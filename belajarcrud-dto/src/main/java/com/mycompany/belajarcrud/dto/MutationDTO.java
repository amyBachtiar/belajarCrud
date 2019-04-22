package com.mycompany.belajarcrud.dto;

/**
 *
 * @author tika
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

public class MutationDTO {
    private String empID;
	private String empName;
	private String position;
	private String finalPosition;
	private boolean mutated;
	private String mutationNumber;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
	private Date mutationDate;
	//private String mutationBatch;
	
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
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
	
	//create data Employee dummy
	@JsonIgnore
	public MutationDTO getInstance() {
		MutationDTO dto = new MutationDTO();
		dto.setEmpID("ID-001");
		dto.setEmpName("Masukkan Nama");
		dto.setPosition("Masukkan Posisi");
		dto.setMutated(true);
		Date mutdate = new Date();
		dto.setMutationDate(mutdate);
		//dto.setMutationBatch("Batch-01");
		dto.setMutationNumber("MX-100031");
		return dto;
	}
}
