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
 * @author Eksad
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

    public Jobdesc() {
    }

    public Jobdesc(String jobdescId, String name, String description) {
        this.jobdescId = jobdescId;
        this.name = name;
        this.description = description;
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
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(this == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Jobdesc other = (Jobdesc) obj;
        if (!Objects.equals(this.id, other.id)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.jobdescId);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean sameIdentityAs(Jobdesc other){
        return this.equals(other);
    }
}