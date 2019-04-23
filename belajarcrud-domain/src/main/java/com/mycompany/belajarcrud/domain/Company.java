/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain;

import com.eksad.ddms.common.util.object.EntityObject;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
/**
 *
 * @author amelia
 */
@Entity
@Table(name = "MST_COMP")
public class Company implements EntityObject<Company>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String companyID;
    private String companyName;
    private String companyAdd;
    private String companyPhone;
    private String companyDesc;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name =  "companyID", referencedColumnName = "companyID")
    private Set<Employee> employees;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    private Set<Jobdesc> jobdescs;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    private Set<Mutation> mutations; 
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    private Set<Assessment> assessments;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    private Set<Recruitment> recruitments;

    public Company() {
    }

    public Company(String companyID, String companyName, String companyAdd, String companyPhone, String companyDesc, Set<Employee> employees, Set<Jobdesc> jobdescs, Set<Mutation> mutations, Set<Assessment> assessments, Set<Recruitment> recruitments) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyAdd = companyAdd;
        this.companyPhone = companyPhone;
        this.companyDesc = companyDesc;
        this.employees = employees;
        this.jobdescs = jobdescs;
        this.mutations = mutations;
        this.assessments = assessments;
        this.recruitments = recruitments;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Jobdesc> getJobdesc() {
        return jobdescs;
    }

    public void setJobdesc(Set<Jobdesc> jobdescs) {
        this.jobdescs = jobdescs;
    }

    public Set<Jobdesc> getJobdescs() {
        return jobdescs;
    }

    public void setJobdescs(Set<Jobdesc> jobdescs) {
        this.jobdescs = jobdescs;
    }

    public Set<Mutation> getMutations() {
        return mutations;
    }

    public void setMutations(Set<Mutation> mutations) {
        this.mutations = mutations;
    }

    public Set<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(Set<Assessment> assessments) {
        this.assessments = assessments;
    }

    public Set<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(Set<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.companyID);
        hash = 41 * hash + Objects.hashCode(this.companyName);
        hash = 41 * hash + Objects.hashCode(this.companyAdd);
        hash = 41 * hash + Objects.hashCode(this.companyPhone);
        hash = 41 * hash + Objects.hashCode(this.companyDesc);
        hash = 41 * hash + Objects.hashCode(this.employees);
        hash = 41 * hash + Objects.hashCode(this.jobdescs);
        hash = 41 * hash + Objects.hashCode(this.mutations);
        hash = 41 * hash + Objects.hashCode(this.assessments);
        hash = 41 * hash + Objects.hashCode(this.recruitments);
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
        final Company other = (Company) obj;
        return true;
    }
    
    
    
    
    
    @Override
    public boolean sameIdentityAs(Company other) {
        return this.equals(other);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
