package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Mega
 */
public class EmployeeDTO {
    
    private String empId;
    private String empName;
    private String position;
    private boolean empStatus;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date birthDate;
    
    private String companyId;
    private List<JobdescDTO> empJobs;
    private List<AttendanceDTO> empAttendancesDTOs;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public boolean isEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(boolean empStatus) {
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

    public List<AttendanceDTO> getEmpAttendancesDTOs() {
        return empAttendancesDTOs;
    }

    public void setEmpAttendancesDTOs(List<AttendanceDTO> empAttendancesDTOs) {
        this.empAttendancesDTOs = empAttendancesDTOs;
    }
    
    // create data Employee dummy 
    @JsonIgnore
    public EmployeeDTO getInstance() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmpId("ID-001");
        dto.setEmpName("Masukkan Nama");
        dto.setPosition("Masukkan Posisi");
        dto.setEmpStatus(true);
        Date lahir=new Date();
        dto.setBirthDate(lahir);
        dto.setCompanyId("C-001");
        dto.setEmpJobs(new ArrayList<>(Arrays.asList(new JobdescDTO().getInstance())));
        dto.setEmpAttendancesDTOs(new ArrayList<>(Arrays.asList(new AttendanceDTO().getInstance())));
        return dto;
    }
}

