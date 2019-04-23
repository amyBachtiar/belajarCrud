package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ilma
 */

public class JobseekerDTO {
    
    private String jobID;
    private String name;
    private String education;
    private int gpa;
    private String university;
    private String intended_position;
    private List<RecruitmentDTO> jobRec;

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

    public List<RecruitmentDTO> getJobRec() {
        return jobRec;
    }

    public void setJobRec(List<RecruitmentDTO> jobRec) {
        this.jobRec = jobRec;
    }

    

      // create data dummy
    @JsonIgnore
    public JobseekerDTO getInstance() {
        JobseekerDTO dto = new JobseekerDTO();
        dto.setJobID("J-001");
        dto.setName("Masukkan Nama");
        dto.setEducation("Masukkan Education");
        dto.setGpa(4);
        dto.setUniversity("Masukkan Universitas");
        dto.setIntended_position("Masukkan Intended Position ");
        dto.setJobRec(new ArrayList<>(Arrays.asList(new RecruitmentDTO().getInstance())));
        return dto;
    }
   
}