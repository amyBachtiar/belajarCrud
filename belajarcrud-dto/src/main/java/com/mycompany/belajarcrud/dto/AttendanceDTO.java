/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

/**
 *
 * @author noldy
 */
public class AttendanceDTO {
    
    private String code;
    
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timeIn;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timeOut;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    
    @JsonIgnore
    public AttendanceDTO getInstance(){
        AttendanceDTO dto = new AttendanceDTO();
        Date waktu = new Date();
        dto.setDate(waktu);
        dto.setTimeIn(waktu);
        dto.setTimeOut(waktu);
        return dto;
    }
}
