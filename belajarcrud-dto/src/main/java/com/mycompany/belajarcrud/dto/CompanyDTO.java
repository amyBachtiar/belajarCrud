/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author eksad
 */
public class CompanyDTO {
    
    private String companyID;
    private String companyName;
    private String companyAdd;
    private String companyPhone;
    private String companyDesc;

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAdd() {
        return companyAdd;
    }

    public void setCompanyAdd(String companyAdd) {
        this.companyAdd = companyAdd;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    
     
    
    //dummy
    @JsonIgnore
    public CompanyDTO getInstance(){
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyID("comp001");
        dto.setCompanyName("eksad");
        dto.setCompanyAdd("Bandung");
        dto.setCompanyPhone("022-123456");
        dto.setCompanyDesc("it comp");
        return dto;
    }
}
