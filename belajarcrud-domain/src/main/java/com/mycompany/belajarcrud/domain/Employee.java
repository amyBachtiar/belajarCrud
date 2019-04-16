package com.mycompany.belajarcrud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.NonNull;

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

    private String empId;
    private String empName;
    private String position;
    private boolean empStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDate;

    //@JsonIgnore
    //@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="attendance_id", referencedColumnName = "id")
    //private Set<Attendance> listAttendance;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId", referencedColumnName = "companyId")
    private Company company;
            
    public Employee() {
    }

    public Employee(String empId, String empName, String position, boolean empStatus, Date birthDate) {
        this.empId = empId;
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

//    public Set<Attendance> getListAttendance() {
//        return listAttendance;
//    }
//
//    public void setListAttendance(Set<Attendance> listAttendance) {
//        this.listAttendance = listAttendance;
//    }

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
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.empId);
        hash = 59 * hash + Objects.hashCode(this.empName);
        hash = 59 * hash + Objects.hashCode(this.position);
        hash = 59 * hash + (this.empStatus ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.birthDate);
        //hash = 59 * hash + Objects.hashCode(this.listAttendance);
        return hash;
    }

    @Override
    public boolean sameIdentityAs(Employee other) {
        return this.equals(other);
    }
}
