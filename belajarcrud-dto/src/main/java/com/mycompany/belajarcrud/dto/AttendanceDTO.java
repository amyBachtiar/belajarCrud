
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

/**
 *
 * @author Reza Agika Putra
 */
public class AttendanceDTO {
    
    private String empId;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss a zzz")
    private Date timeIn;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss a zzz")
    private Date timeOut;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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
    
    //Create data Dummy
    @JsonIgnore
    public AttendanceDTO getInstance(){
        AttendanceDTO dto = new AttendanceDTO();
        dto.setEmpId("X-YYYY");
        Date waktu = new Date();
        dto.setDate(waktu);
        dto.setTimeIn(waktu);
        dto.setTimeOut(waktu);
        return dto;
    }

}