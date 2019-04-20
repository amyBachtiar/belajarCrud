package com.mycompany.belajarcrud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Date;
import java.util.Objects;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="MUTATION_DATA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Mutation implements EntityObject<Mutation> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
//    @Column(unique = true)
//    @NotNull(message = "empID cannot be null")
    private String empID;
    private String empName;
    private String position;
    private String finalPosition;
    private boolean mutated;
    private String mutationNumber;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date mutationDate;
    
    @OneToMany(mappedBy = "mutation")
    private Set<Employee> employees;
    //mutation have many batches
    
    
//    @OneToMany
//    private Set<MutationBatch> mutationBatch;
    
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    

    public Mutation() {
    }

    public Mutation(String empName, String position, String finalPosition, boolean mutated, String mutationNumber, Date mutationDate, Set<Employee> employees) {
//        this.empID = empID;
        this.empName = empName;
        this.position = position;
        this.finalPosition = finalPosition;
        this.mutated = mutated;
        this.mutationNumber = mutationNumber;
        this.mutationDate = mutationDate;
        this.company = company;
        this.employees = employees;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    public Date getMutationDate() {
        return mutationDate;
    }

    public void setMutationDate(Date mutationDate) {
        this.mutationDate = mutationDate;
    }

//    public Set<MutationBatch> getMutationBatch() {
//        return mutationBatch;
//    }
//
//    public void setMutationBatch(Set<MutationBatch> mutationBatch) {
//        this.mutationBatch = mutationBatch;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(String finalPosition) {
        this.finalPosition = finalPosition;
    }

    public boolean isMutated() {
        return mutated;
    }

    public void setMutated(boolean mutated) {
        this.mutated = mutated;
    }

    public String getMutationNumber() {
        return mutationNumber;
    }

    public void setMutationNumber(String mutationNumber) {
        this.mutationNumber = mutationNumber;
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
        hash = 83 * hash + Objects.hashCode(this.empID);
        hash = 83 * hash + Objects.hashCode(this.empName);
        hash = 83 * hash + Objects.hashCode(this.position);
        hash = 83 * hash + Objects.hashCode(this.finalPosition);
        hash = 83 * hash + (this.mutated ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.mutationNumber);
        hash = 83 * hash + Objects.hashCode(this.employees);
        hash = 83 * hash + Objects.hashCode(this.mutationDate);
        
        return hash;
    }

    @Override
    public boolean sameIdentityAs(Mutation other) {
        return this.equals(other);
    }
    
    
}
