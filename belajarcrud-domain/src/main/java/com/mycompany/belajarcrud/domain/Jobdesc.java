/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author desiwl
 */

@Entity
@Table(name = "MST_JOBDESC")
public class Jobdesc implements EntityObject<Jobdesc>{
    
    /**
     * Hibernate purpose
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String jobdescId;
    private String name;
    private String description;
//    
//    @JsonIgnore
//    @ManyToMany(mappedBy="jobdesc")
//    private Set<Employee> employees;
//    
//    @OneToMany(mappedBy="jobdesc")
//    private Set<Company> companys;
    
    public Jobdesc() {
    }

    public Jobdesc(String jobdescId, String name, String description) {
        this.jobdescId = jobdescId;
        this.name = name;
        this.description = description;
//        this.employees=employees;
//        this.companys=companys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }
//
//    public Set<Company> getCompanys() {
//        return companys;
//    }
//
//    public void setCompanys(Set<Company> companys) {
//        this.companys = companys;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.jobdescId);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.description);
//        hash = 97 * hash + Objects.hashCode(this.employees);
//        hash = 97 * hash + Objects.hashCode(this.companys);
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
        final Jobdesc other = (Jobdesc) obj;
        return true;
    }
    
    
    
   

   

    @Override
    public boolean sameIdentityAs(Jobdesc other){
        return this.equals(other);
    }
}