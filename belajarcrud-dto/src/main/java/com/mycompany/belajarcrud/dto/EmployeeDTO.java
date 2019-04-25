package com.mycompany.belajarcrud.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class EmployeeDTO {
	
        private String empId;
	private String empName;
	private String position;
	private Boolean empStatus;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yy" )
	private Date birthDate;
        private List<JobdescDTO> empJobs;
        private List<AttendanceDTO>empAttendancesDTOs;
        private String companyID;
//        private PayrollDTO payrollDTO;

        public EmployeeDTO() {
        }

        public EmployeeDTO(String empId, String empName, String position, Boolean empStatus, Date birthDate, List<JobdescDTO> empJobs, List<AttendanceDTO> empAttendancesDTOs, String companyID) {
            this.empId = empId;
            this.empName = empName;
            this.position = position;
            this.empStatus = empStatus;
            this.birthDate = birthDate;
            this.empJobs = empJobs;
            this.empAttendancesDTOs = empAttendancesDTOs;
            this.companyID = companyID;
        }

        
        public List<AttendanceDTO> getEmpAttendancesDTOs() {
            return empAttendancesDTOs;
        }

        public void setEmpAttendancesDTOs(List<AttendanceDTO> empAttendancesDTOs) {
            this.empAttendancesDTOs = empAttendancesDTOs;
        }

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
	

        public List<JobdescDTO> getEmpJobs() {
            return empJobs;
        }
        
        public void setEmpJobs(List<JobdescDTO> empJobs) {
            this.empJobs = empJobs;
        }

        public String getCompanyID() {
            return companyID;
        }

        public void setCompanyID(String companyID) {
            this.companyID = companyID;
        }

        


	@JsonIgnore
	public EmployeeDTO getInstance() {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(UUID.randomUUID().toString().substring(0,6));
		dto.setCompanyID(UUID.randomUUID().toString().substring(0, 6));
                dto.setEmpName("Masukkan Nama");
		dto.setPosition("Masukkan Posisi");
		dto.setEmpStatus(true);
		Date lahir = new Date();
		dto.setBirthDate(lahir);
                dto.setEmpJobs(new ArrayList<>(Arrays.asList(new JobdescDTO().getInstance())));
                dto.setEmpAttendancesDTOs(new ArrayList<>(Arrays.asList(new AttendanceDTO().getInstance())));
//                dto.setPayrollDTO(dto.getPayrollDTO().getInstance());
		return dto;
	}
}