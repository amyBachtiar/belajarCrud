/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

/**
 *
 * @author eksad-edwina
 */
public class CNBItemDTO {
    
    private String cnbitemID;

    private double pensiun;
    private double insurance;

    public CNBItemDTO() {
    }

    public String getCnbitemID() {
        return cnbitemID;
    }

    public void setCnbitemID(String cnbitemID) {
        this.cnbitemID = cnbitemID;
    }

    public double getPensiun() {
        return pensiun;
    }

    public void setPensiun(double pensiun) {
        this.pensiun = pensiun;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }
    
    //create data dummy
    @JsonIgnore
    public CNBItemDTO getInstance(){
        CNBItemDTO dto = new CNBItemDTO();
        dto.setCnbitemID("CNBITEMID");
//        dto.setBaseSalary(5000);
        dto.setPensiun(5000);
        dto.setInsurance(5000);
        return dto;
    }
    
}
