/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author William
 */
public class CNBDTO {
     private String empName;
    private String empID;
   // @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
//     private double baseSalary;
//    private PayrollDTO Salary;
    private List<CNBItemDTO> cnbItemsDTOs;
    private PayrollDTO Salary;
    

    public CNBDTO() {
    }

    public PayrollDTO getSalary() {
        return Salary;
    }

    public void setSalary(PayrollDTO Salary) {
        this.Salary = Salary;
    }
    
    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
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

//    public PayrollDTO getSalary() {
//        return Salary;
//    }
//
//    public void setSalary(PayrollDTO Salary) {
//        this.Salary = Salary;
//    }
    
    
   
    
    //create data dummy
    @JsonIgnore
    public CNBDTO getInstance(){
        CNBDTO dto = new CNBDTO();
        dto.setEmpName("Edwin");
        dto.setEmpID(UUID.randomUUID().toString().substring(0, 6));
        dto.setCnbItemsDTOs(new ArrayList<>(Arrays.asList(
                new CNBItemDTO().getInstance())));
        dto.setSalary(dto.getSalary());
        return dto;
    }
    
}
