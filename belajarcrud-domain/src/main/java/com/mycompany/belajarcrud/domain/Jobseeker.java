package com.mycompany.belajarcrud.domain;

import com.mycompany.belajarcrud.common.EntityObject;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ilma
 */

@Entity
@Table(name = "MST_JOBSEEKER")
@Inheritance(strategy = InheritanceType.JOINED)
public class Jobseeker implements EntityObject<Jobseeker>{

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
    
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
        name ="Job_Rec",
            joinColumns = {@JoinColumn(name="jobID")},
            inverseJoinColumns = { @JoinColumn(name = "recID")})

    private Set<Recruitment> rec = new HashSet<Recruitment>();
    
    public Jobseeker() {
       }

    public Jobseeker(String jobID, String name, String education, int gpa, String university, String intended_position) {
        this.jobID = jobID;
        this.name = name;
        this.education = education;
        this.gpa = gpa;
        this.university = university;
        this.intended_position = intended_position;
    }

    public Set<Recruitment> getRec() {
        return rec;
    }

    public void setRec(Set<Recruitment> rec) {
        this.rec = rec;
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
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.jobID);
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.education);
        hash = 43 * hash + this.gpa;
        hash = 43 * hash + Objects.hashCode(this.university);
        hash = 43 * hash + Objects.hashCode(this.intended_position);
        hash = 43 * hash + Objects.hashCode(this.rec);
        return hash;
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
        return true;
    }

    
    
    @Override
    public boolean sameIdentityAs(Jobseeker other) {
        // TODO Auto-generated method stub
        return this.equals(other);
    }
}
