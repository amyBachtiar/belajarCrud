package com.mycompany.belajarcrud.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.eksad.ddms.common.util.object.EntityObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
@Table(name="MST_EMPLOYEE")
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
        
        @ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
        @JoinTable(
            name = "Employee_Job",
                joinColumns = { @JoinColumn(name = "employee_id")},
                inverseJoinColumns = { @JoinColumn(name = "job_id")})
        private Set<Jobdesc> jobs = new HashSet<Jobdesc>();
                        
        @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
        @JoinTable(
        name = "Employee_asses", 
        joinColumns = { @JoinColumn(name = "empid") }, 
        inverseJoinColumns = { @JoinColumn(name = "empAssessId") })
        private Set<Assessment> assess = new HashSet<Assessment>();
                
        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "empId", referencedColumnName = "empId")
        private Set<Attendance>empAttendances;
        
	public Employee() {
	}
	
	public Employee(String empId, String empName, String position, boolean empStatus, Date birthDate) {
		this.empId = empId;
		this.empName = empName;
		this.position = position;
		this.empStatus = empStatus;
		this.birthDate = birthDate;
	}

        public Set<Attendance> getEmpAttendances() {
            return empAttendances;
        }

        public void setEmpAttendances(Set<Attendance> empAttendances) {
            this.empAttendances = empAttendances;
        }

        
        
        public Set<Assessment> getAssess() {
            return assess;
        }

        public void setAssess(Set<Assessment> assess) {
            this.assess = assess;
        }

        
        
        public Set<Jobdesc> getJobs() {
            return jobs;
        }

        public void setJobs(Set<Jobdesc> jobs) {
            this.jobs = jobs;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.empId);
        hash = 97 * hash + Objects.hashCode(this.empName);
        hash = 97 * hash + Objects.hashCode(this.position);
        hash = 97 * hash + (this.empStatus ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.birthDate);
        hash = 97 * hash + Objects.hashCode(this.jobs);
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
        return true;
    }

    @Override
    public boolean sameIdentityAs(Employee other) {
        return this.equals(other);
    }
	
}