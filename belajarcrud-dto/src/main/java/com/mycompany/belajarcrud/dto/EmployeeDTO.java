package com.mycompany.belajarcrud.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmployeeDTO {
	private String empId;
	private String empName;
	private String position;
	private Boolean empStatus;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yy" )
	private Date birthDate;
	private String companyId;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
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
	public Boolean isEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(Boolean empStatus) {
		this.empStatus = empStatus;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	@JsonIgnore
	public EmployeeDTO getInstance() {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId("ID-001");
		dto.setEmpName("Masukkan Nama");
		dto.setPosition("Masukkan Posisi");
		dto.setEmpStatus(true);
		Date lahir = new Date();
		dto.setBirthDate(lahir);
		dto.setCompanyId("C-001");
		return dto;
	}
}