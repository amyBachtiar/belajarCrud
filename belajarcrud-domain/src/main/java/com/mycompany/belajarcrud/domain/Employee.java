package com.mycompany.belajarcrud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mega
 */
@Entity
@Table(name = "MST_EMPLOYEE")
public class Employee implements EntityObject<Employee> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String companyId;
    private String empId;
    private String empName;
    private String position;
    private boolean empStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDate;
    
    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
    @JoinTable(
        name = "Employee_Job", 
        joinColumns = { @JoinColumn(name = "employee_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "job_id") })
    private Set<Jobdesc> jobs = new HashSet<Jobdesc>();
    
    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName = "companyId", nullable = false, insertable = false, updatable = false)
    private Company company;
    
//    @ManyToOne
//    @JoinColumn(name = "mutation_id", nullable = true)//biar employee ga harus mutasi
//    private Mutation mutation;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "empId", referencedColumnName = "empId", nullable = true, insertable = true, updatable = true)
    private Set<Attendance> empAttendances;
    
//    @OneToMany
//    private Set<MutationBatch> mutationBatch;
            
    public Employee() {
    }

    
    public Employee(
            String empId, 
            String empName, 
            String position, 
            boolean empStatus, 
            Date birthDate,
            Set<Jobdesc> jobs, 
            Set<Attendance> empAttendances,
            Company company, String companyId) {
        this.empId = empId;
        this.empName = empName;
        this.position = position;
        this.empStatus = empStatus;
        this.birthDate = birthDate;
        this.jobs=jobs;
        this.empAttendances=empAttendances;
        this.company = company;
        this.companyId = companyId;
//        this.mutation = mutation;
//        this.mutationBatch = mutationBatch;
    }

//    public Mutation getMutation() {
//        return mutation;
//    }
//
//    public void setMutation(Mutation mutation) {
//        this.mutation = mutation;
//    }

//    public Set<MutationBatch> getMutationBatch() {
//        return mutationBatch;
//    }
//
//    public void setMutationBatch(Set<MutationBatch> mutationBatch) {
//        this.mutationBatch = mutationBatch;
//    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

    public boolean isEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(boolean empStatus) {
        this.empStatus = empStatus;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Jobdesc> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Jobdesc> jobs) {
        this.jobs = jobs;
    }

    public Set<Attendance> getEmpAttendances() {
        return empAttendances;
    }

    public void setEmpAttendances(Set<Attendance> empAttendances) {
        this.empAttendances = empAttendances;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.companyId);
        hash = 89 * hash + Objects.hashCode(this.empId);
        hash = 89 * hash + Objects.hashCode(this.empName);
        hash = 89 * hash + Objects.hashCode(this.position);
        hash = 89 * hash + (this.empStatus ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.birthDate);
        hash = 89 * hash + Objects.hashCode(this.jobs);
        hash = 89 * hash + Objects.hashCode(this.company);
//        hash = 89 * hash + Objects.hashCode(this.mutation);
        hash = 89 * hash + Objects.hashCode(this.empAttendances);
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean sameIdentityAs(Employee other) {
        return this.equals(other);
    }
}
