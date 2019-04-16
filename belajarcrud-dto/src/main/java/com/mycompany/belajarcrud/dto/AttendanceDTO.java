package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author amy
 */
public class AttendanceDTO {
    
    private String employeeId;
    private String code;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss a zzz")
    private Date timeIn;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss a zzz")
    private Date timeOut;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) { 
        this.code = code;
    }
    
    //Create data Dummy
    @JsonIgnore
    public AttendanceDTO getInstance(){
        AttendanceDTO dto = new AttendanceDTO();
        dto.setEmployeeId("X-YYYY");
        Date waktu = new Date();
        dto.setDate(waktu);
        dto.setTimeIn(waktu);
        dto.setTimeOut(waktu);
        return dto;
    }

}