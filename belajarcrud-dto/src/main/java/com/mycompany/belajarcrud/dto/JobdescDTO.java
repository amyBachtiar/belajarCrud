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
 * @author desi
 */
public class JobdescDTO {
    private String jobdescId;
	 private String name;
	 private String description;
         private String companyID;

    public JobdescDTO() {
    }

    public JobdescDTO(String jobdescId, String name, String description, String companyID) {
        this.jobdescId = jobdescId;
        this.name = name;
        this.description = description;
        this.companyID = companyID;
    }
         
         
	public String getJobdescId() {
		return jobdescId;
	}
	public void setJobdescId(String jobdescId) {
		this.jobdescId = jobdescId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
	 
        
	 // create data dummy
    @JsonIgnore
    public JobdescDTO getInstance() {
        JobdescDTO dto = new JobdescDTO();
        dto.setJobdescId(UUID.randomUUID().toString().substring(0, 6));
        dto.setCompanyID(UUID.randomUUID().toString().substring(0, 6));
        dto.setName("Isi Name");
        dto.setDescription("Isi Description");
        return dto;
    }
}