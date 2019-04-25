package com.mycompany.belajarcrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
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
	
        @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
        @JoinColumn(name="empAssessId", referencedColumnName="empAssessId")
        private Set<Employee> employees;
        
        @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(name = "companyID", nullable = false)
        private Company company;
       
        
	public Assessment () {
		
	}

        public Assessment(String empAssessId, int empAssessment, Set<Employee> employees, Company company) {
            this.empAssessId = empAssessId;
            this.empAssessment = empAssessment;
            this.employees = employees;
            this.company = company;
        }

       

        public Set<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(Set<Employee> employees) {
            this.employees = employees;
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

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 67 * hash + Objects.hashCode(this.empAssessId);
            hash = 67 * hash + this.empAssessment;
            hash = 67 * hash + Objects.hashCode(this.employees);
            hash = 67 * hash + Objects.hashCode(this.company);
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
            final Assessment other = (Assessment) obj;
            return true;
        }
	
        
	
    @Override
    public boolean sameIdentityAs(Assessment other) {
        return this.equals(other);
    }

	
}
