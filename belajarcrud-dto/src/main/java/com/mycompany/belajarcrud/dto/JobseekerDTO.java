package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reniwijayanti
 */
public class JobseekerDTO {
    
    private String jobID;
    private String name;
    private String education;
    private int gpa;
    private String university;
    private String intended_position;

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getIntended_position() {
        return intended_position;
    }

    public void setIntended_position(String intended_position) {
        this.intended_position = intended_position;
    }



  
      // create data dummy
    @JsonIgnore
    public JobseekerDTO getInstance() {
        JobseekerDTO dto = new JobseekerDTO();
        dto.setJobID("JobseekerID : ");
        dto.setName("Name :");
        dto.setEducation("Education :");
        dto.setGpa(4);
        dto.setUniversity("University : ");
        dto.setIntended_position("Intended_position: ");
        return dto;
    }
   
}
