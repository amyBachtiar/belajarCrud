/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.dto;

/**
 *
 * @author eksad
 */
public class JobdescPostDTO {
    private String jobdescId;
    private String name;
    private String description;
    private String compId;

    public JobdescPostDTO(String jobdescId, String name, String description, String compId) {
        this.jobdescId = jobdescId;
        this.name = name;
        this.description = description;
        this.compId = compId;
    }

    public JobdescPostDTO() {
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

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }
    
    
}
