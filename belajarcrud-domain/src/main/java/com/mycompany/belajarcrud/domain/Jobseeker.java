package com.mycompany.belajarcrud.domain;

import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author reniwijayanti
 */
@Entity
@Table(name = "JOBSEEKER")
@Inheritance(strategy = InheritanceType.JOINED)
public class Jobseeker implements EntityObject<Jobseeker>{

/**
     * Hibernate purpose
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
    @Column(unique = true)
    @NotNull(message = "Jobseeker_ID Tidak boleh kosong")
    private String jobID;
    
    private String name;
    private String education;
    private int gpa;
    private String university;
    private String intended_position;
    
    @OneToMany(mappedBy="jobseeker", cascade=CascadeType.ALL)
    private Set<Recruitment> recruitments;
      
    public Jobseeker() {
       }

    public Jobseeker(String jobID, String name, String education, int gpa, String university, String intended_position, Set<Recruitment> recruitments) {
        this.jobID = jobID;
        this.name = name;
        this.education = education;
        this.gpa = gpa;
        this.university = university;
        this.intended_position = intended_position;
        this.recruitments = recruitments;
    }

    

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Set<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(Set<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }

        
    @Override
    public boolean sameIdentityAs(Jobseeker other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }   
    
    
}