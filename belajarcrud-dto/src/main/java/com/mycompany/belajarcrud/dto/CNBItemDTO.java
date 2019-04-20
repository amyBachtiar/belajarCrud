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
    
    private String CnBempID;
   // @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
//    private double BaseSalary;
    private double pensiun;
    private double insurance;

    public CNBItemDTO() {
    }

    public String getCnBempID() {
        return CnBempID;
    }

    public void setCnBempID(String CnBempID) {
        this.CnBempID = CnBempID;
    }

    

//    public double getBaseSalary() {
//        return BaseSalary;
//    }
//
//    public void setBaseSalary(double BaseSalary) {
//        this.BaseSalary = BaseSalary;
//    }

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
        dto.setCnBempID(UUID.randomUUID().toString().substring(0, 6));
//        dto.setBaseSalary(5000);
        dto.setPensiun(5000);
        dto.setInsurance(5000);
        return dto;
    }
    
}
