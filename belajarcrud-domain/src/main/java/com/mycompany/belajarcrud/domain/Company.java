package com.mycompany.belajarcrud.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mega
 */
@Entity
@Table(name="MST_COMPANY")
public class Company implements EntityObject<Company>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    @Column(unique = true)
    @NotNull(message = "companyName cannot be null")
    private String companyId;
    private String companyName;
    private String companyDesc;
    
    //@JsonIgnore
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Recruitment> listRecrutment ;
    
    //@JsonIgnore
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> listEmployee ;
    
//    @OneToMany(mappedBy = "company")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="compId")
    private Set<Mutation> mutations;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="compId")
    private Set<Jobdesc>compJobs;
    
    public Company(){
        
    }

    public Company(String companyId, String companyName, String companyDesc, Set<Recruitment> listRecrutment, Set<Employee> listEmployee, Set<Mutation> mutations, Set<Jobdesc> compJobs) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDesc = companyDesc;
        this.listRecrutment = listRecrutment;
        this.listEmployee = listEmployee;
        this.mutations = mutations;
        this.compJobs = compJobs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public Set<Recruitment> getListRecrutment() {
        return listRecrutment;
    }

    public void setListRecrutment(Set<Recruitment> listRecrutment) {
        this.listRecrutment = listRecrutment;
    }

    public Set<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(Set<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public Set<Mutation> getMutations() {
        return mutations;
    }

    public void setMutations(Set<Mutation> mutations) {
        this.mutations = mutations;
    }

    public Set<Jobdesc> getCompJobs() {
        return compJobs;
    }

    public void setCompJobs(Set<Jobdesc> compJobs) {
        this.compJobs = compJobs;
    }

    
    
   

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 59 * hash + Objects.hashCode(this.companyId);
//        hash = 59 * hash + Objects.hashCode(this.companyName);
//        hash = 59 * hash + Objects.hashCode(this.companyDesc);
//        hash = 59 * hash + Objects.hashCode(this.listEmployee);
//        hash = 59 * hash + Objects.hashCode(this.mutations);
//        hash = 59 * hash + Objects.hashCode(this.compJobs);
//        return hash;
//    }

    @Override
    public boolean sameIdentityAs(Company other) {
        return this.equals(other);
    }
}
