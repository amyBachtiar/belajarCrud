package com.mycompany.belajarcrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Objects;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author addi jo
 */
@Entity
@Table(name = "MST_ASSESSMENT")
public class Assessment implements EntityObject<Assessment> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	private String empAssessId;
	private int empAssessment;
	
	public Assessment () {
		
	}

	public Assessment(Integer id, String empAssessId, int empAssessment) {
		this.empAssessId = empAssessId;
		this.empAssessment = empAssessment;
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpAssessId() {
		return empAssessId;
	}

	public void setEmpAssessId(String empAssessId) {
		this.empAssessId = empAssessId;
	}

	public int getEmpAssessment() {
		return empAssessment;
	}

	public void setEmpAssessment(int empAssessment) {
		this.empAssessment = empAssessment;
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
        final Bizpar other = (Bizpar) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
	
    @Override
    public boolean sameIdentityAs(Assessment other) {
        return this.equals(other);
    }
	
}
