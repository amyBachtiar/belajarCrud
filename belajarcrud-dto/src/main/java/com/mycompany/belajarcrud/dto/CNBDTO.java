/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.belajarcrud.dto.CNBItemDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author eksad-edwina
 */
public class CNBDTO {
    

    private String cnbID;
    private boolean cnbStatus;
    private String cnbDesc;
   // @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
//     private double baseSalary;
    private PayrollDTO Salary;
    private List<CNBItemDTO> cnbItemsDTOs;
    private EmployeeDTO employeeDTO;
    

    public CNBDTO() {
    }

    public String getCnbID() {
        return cnbID;
    }

    public void setCnbID(String cnbID) {
        this.cnbID = cnbID;
    }



    public List<CNBItemDTO> getCnbItemsDTOs() {
        return cnbItemsDTOs;
    }

    public void setCnbItemsDTOs(List<CNBItemDTO> cnbItemsDTOs) {
        this.cnbItemsDTOs = cnbItemsDTOs;
    }

    public PayrollDTO getSalary() {
        return Salary;
    }

    public void setSalary(PayrollDTO Salary) {
        this.Salary = Salary;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public boolean isCnbStatus() {
        return cnbStatus;
    }

    public void setCnbStatus(boolean cnbStatus) {
        this.cnbStatus = cnbStatus;
    }

    public String getCnbDesc() {
        return cnbDesc;
    }

    public void setCnbDesc(String cnbDesc) {
        this.cnbDesc = cnbDesc;
    }
    
    //create data dummy
    @JsonIgnore
    public CNBDTO getInstance(){
        CNBDTO dto = new CNBDTO();
//        dto.setEmpName("Edwin");
        dto.setCnbID("CNBEMP-001");
        dto.setCnbStatus(true);
        dto.setCnbDesc("Dana Pensiun dan Dana Asuransi");
//        dto.setCnbItemsDTOs(new ArrayList<>(Arrays.asList(
//                new CNBItemDTO().getInstance())));
        PayrollDTO pay = new PayrollDTO();
//        dto.setSalary(pay.getInstance());
//        PayrollDTO payrolldto = new PayrollDTO(); 
//        payrolldto.setPayItemsDTOs(getSalary());
        return dto;
    }
    
}