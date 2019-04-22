package com.mycompany.belajarcrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "RECRUITMENT")
public class Recruitment implements EntityObject<Recruitment> {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column
    @NotNull(message = "Recruitment_ID Harus diIsi")
    private String recID;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "jobjobID", nullable = false)
    private Jobseeker jobseeker;
    
    private String recType;
    private boolean status;

    public Recruitment() {
    }

    public Recruitment(String recID, Jobseeker jobseeker, String recType, boolean status) {
        this.recID = recID;
        this.jobseeker = jobseeker;
        this.recType = recType;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecID() {
        return recID;
    }

    public void setRecID(String recID) {
        this.recID = recID;
    }

    public Jobseeker getJobseeker() {
        return jobseeker;
    }

    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    

    
    
    
    
    @Override
    public boolean sameIdentityAs(Recruitment other) {
          throw new UnsupportedOperationException("Not supported yet.");
    }

}