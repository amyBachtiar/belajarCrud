package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private List<AttendanceDTO> attendanceDTOs;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
    private Date birthDate;

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

    public List<AttendanceDTO> getAttendanceDTOs() {
        return attendanceDTOs;
    }

    public void setAttendanceDTOs(List<AttendanceDTO> attendanceDTOs) {
        this.attendanceDTOs = attendanceDTOs;
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
        return dto;
    }
}

