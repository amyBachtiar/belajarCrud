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
public class EmployeePostDTO {
    
    private String companyId; //masukin parent id
    private String empId;
    private String empName;
    private String position;
    private boolean empStatus;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date birthDate;
    
//    private List<JobdescDTO> empJobs;
//    private List<AttendanceDTO> empAttendancesDTOs;
//    private CNBDTO cnbDTO;

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

//    public List<JobdescDTO> getEmpJobs() {
//        return empJobs;
//    }
//
//    public void setEmpJobs(List<JobdescDTO> empJobs) {
//        this.empJobs = empJobs;
//    }
//
//    public List<AttendanceDTO> getEmpAttendancesDTOs() {
//        return empAttendancesDTOs;
//    }
//
//    public void setEmpAttendancesDTOs(List<AttendanceDTO> empAttendancesDTOs) {
//        this.empAttendancesDTOs = empAttendancesDTOs;
//    }

//    public CNBDTO getCnbDTO() {
//        return cnbDTO;
//    }
//
//    public void setCnbDTO(CNBDTO cnbDTO) {
//        this.cnbDTO = cnbDTO;
//    }
        
    // create data Employee dummy 
    @JsonIgnore
    public EmployeePostDTO getInstance() {
        EmployeePostDTO dto = new EmployeePostDTO();
        dto.setEmpId("ID-001");
        dto.setEmpName("Masukkan Nama");
        dto.setPosition("Masukkan Posisi");
        dto.setEmpStatus(true);
        Date lahir=new Date();
        dto.setBirthDate(lahir);
//        dto.setEmpJobs(new ArrayList<>(Arrays.asList(new JobdescDTO().getInstance())));
//        dto.setEmpAttendancesDTOs(new ArrayList<>(Arrays.asList(new AttendanceDTO().getInstance())));
        dto.setCompanyId("C-001");
//        CNBDTO cnb = new CNBDTO();
//        dto.setCnbDTO(cnb.getInstance());
        return dto;
    }
}

