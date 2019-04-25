
package com.mycompany.belajarcrud.domain;

import com.mycompany.belajarcrud.common.EntityObject;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Reza Agika Putra
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
    
//    @ManyToMany(mappedBy = "employee")
//    private Set<Employee>employees=new HashSet<>();
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="compId",nullable = false)
    private Company comps;

    public Jobdesc() {
    }

    public Jobdesc(String jobdescId, String name, String description, Company comps) {
        this.jobdescId = jobdescId;
        this.name = name;
        this.description = description;
        this.comps = comps;
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

    public Company getComps() {
        return comps;
    }

    public void setComps(Company comps) {
        this.comps = comps;
    }

    
//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }
    
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
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.jobdescId);
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean sameIdentityAs(Jobdesc other){
        return this.equals(other);
    }
}
