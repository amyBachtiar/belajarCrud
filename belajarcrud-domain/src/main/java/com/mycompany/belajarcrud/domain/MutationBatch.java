package com.mycompany.belajarcrud.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MUTATION_BATCH")
public class MutationBatch {
    @Id
    private int id;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "mutationid", referencedColumnName = "mutationNumber", nullable = false)
    private Mutation mutation;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "empid", referencedColumnName = "empid", nullable = false)
    private Employee employee;
    
    Date mutationDate;
    
    private int mutationBatch;

    public MutationBatch(Mutation mutation, Employee employee, Date mutationDate, int mutationBatch) {
        this.mutation = mutation;
        this.employee = employee;
        this.mutationDate = mutationDate;
        this.mutationBatch = mutationBatch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getMutationDate() {
        return mutationDate;
    }

    public void setMutationDate(Date mutationDate) {
        this.mutationDate = mutationDate;
    }

    public int getMutationBatch() {
        return mutationBatch;
    }

    public void setMutationBatch(int mutationBatch) {
        this.mutationBatch = mutationBatch;
    }
    
    
}
