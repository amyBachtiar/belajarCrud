/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.belajarcrud.dto.CNBItemDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author eksad-edwina
 */
public class CNBDTO {
    
    private String empName;
    private String empID;
   // @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
    private double BaseSalary;
    private List<CNBItemDTO> cnbItemsDTOs;
    

    public CNBDTO() {
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public double getBaseSalary() {
        return BaseSalary;
    }

    public void setBaseSalary(double BaseSalary) {
        this.BaseSalary = BaseSalary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<CNBItemDTO> getCnbItemsDTOs() {
        return cnbItemsDTOs;
    }

    public void setCnbItemsDTOs(List<CNBItemDTO> cnbItemsDTOs) {
        this.cnbItemsDTOs = cnbItemsDTOs;
    }
    
    
   
    
    //create data dummy
    @JsonIgnore
    public CNBDTO getInstance(){
        CNBDTO dto = new CNBDTO();
        dto.setEmpName("Edwin");
        dto.setEmpID(UUID.randomUUID().toString().substring(0, 6));
        dto.setBaseSalary(5000);
        
        return dto;
    }
    
}
