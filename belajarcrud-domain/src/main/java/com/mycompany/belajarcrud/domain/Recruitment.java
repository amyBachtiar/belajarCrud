package com.mycompany.belajarcrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MST_RECRUITMENT")
public class Recruitment implements EntityObject<Recruitment> {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    private String recID;
    private String recType;
    private boolean status;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;
    
    @ManyToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name="Recruitment_Jobseeker",
            joinColumns = { @JoinColumn(name="recID")},
            inverseJoinColumns={@JoinColumn(name="jobID")}
    )
    private Set<Jobseeker> jobseekers= new HashSet<Jobseeker>();

    public Recruitment() {
    }

    public Recruitment(Integer id, String recID, String recType, boolean status,Set<Jobseeker> jobseekers) {
        this.id = id;
        this.recID = recID;
        this.recType = recType;
        this.status = status;
        this.jobseekers=jobseekers;
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

    public Set<Jobseeker> getJobseekers() {
        return jobseekers;
    }

    public void setJobseekers(Set<Jobseeker> jobseekers) {
        this.jobseekers = jobseekers;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.recID);
        hash = 53 * hash + Objects.hashCode(this.recType);
        hash = 53 * hash + (this.status ? 1 : 0);
        return hash;
    }
    
    @Override
    public boolean sameIdentityAs(Recruitment other) {
          return this.equals(other);
    }

}
