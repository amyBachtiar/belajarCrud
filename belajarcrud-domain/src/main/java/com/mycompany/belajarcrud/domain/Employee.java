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

/**
 *
 * @author Mega
 */
@Entity
@Table(name="MST_EMPLOYEE")
public class Employee implements EntityObject<Employee>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String empID;
    private String empName;
    private String position;
    private boolean empStatus;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
    private Date birthDate;

    public Employee(){
    }

    public Employee(String empID, String empName, String position, boolean empStatus, Date birthDate) {
        this.empID = empID;
        this.empName = empName;
        this.position = position;
        this.empStatus = empStatus;
        this.birthDate = birthDate;
    }

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
        hash = 83 * hash + (this.empStatus ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.birthDate);
        return hash;
    }

    @Override
    public boolean sameIdentityAs(Employee other) {
        return this.equals(other);
    }
}
