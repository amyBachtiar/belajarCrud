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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + (empStatus ? 1231 : 1237);
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() !=obj.getClass()) {
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