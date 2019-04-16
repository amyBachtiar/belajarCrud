package com.mycompany.belajarcrud.domain;

import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author reniwijayanti
 */
@Entity
@Table(name = "JOBSEEKER")
public class Jobseeker implements EntityObject<Jobseeker>{

/**
     * Hibernate purpose
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
    private String jobID;
    private String name;
    private String education;
    private int gpa;
    private String university;
    private String intended_position;
      
    public Jobseeker() {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jobseeker other = (Jobseeker) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.jobID);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.education);
        hash = 67 * hash + this.gpa;
        hash = 67 * hash + Objects.hashCode(this.university);
        hash = 67 * hash + Objects.hashCode(this.intended_position);
        return hash;
    }

   
    @Override
    public boolean sameIdentityAs(Jobseeker other) {
        return this.equals(other);
    }   
    
    
}
