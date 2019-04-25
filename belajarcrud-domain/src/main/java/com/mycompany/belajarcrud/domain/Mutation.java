package com.mycompany.belajarcrud.domain;

/**
 *
 * @author tikaa 
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mst_mutation")
public class Mutation implements EntityObject<Mutation> {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	private String mutationNumber;
	private String finalPosition;
	private boolean mutated;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
	private Date mutationDate;
                
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name =  "mutationNumber", referencedColumnName = "mutationNumber")
        private Set<Employee> employees;
        
        @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(name = "companyID", referencedColumnName = "companyID", nullable = false)
        private Company company;
	
	public Mutation() {
	}

        public Mutation(String mutationNumber, String finalPosition, boolean mutated, Date mutationDate, Set<Employee> employees, Company company) {
            this.mutationNumber = mutationNumber;
            this.finalPosition = finalPosition;
            this.mutated = mutated;
            this.mutationDate = mutationDate;
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
//	public String getPosition() {
//		return position;
//	}
//	public void setPosition(String position) {
//		this.position = position;
//	}
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
	public Date getMutationDate() {
		return mutationDate;
	}
	public void setMutationDate(Date mutationDate) {
		this.mutationDate = mutationDate;
	}
//	public String getMutationBatch() {
//		return mutationBatch;
//	}
//	public void setMutationBatch(String mutationBatch) {
//		this.mutationBatch = mutationBatch;
//	}

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 59 * hash + Objects.hashCode(this.mutationNumber);
            hash = 59 * hash + Objects.hashCode(this.finalPosition);
            hash = 59 * hash + (this.mutated ? 1 : 0);
            hash = 59 * hash + Objects.hashCode(this.mutationDate);
            hash = 59 * hash + Objects.hashCode(this.employees);
            hash = 59 * hash + Objects.hashCode(this.company);
            return hash;
        }
        
        

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		final Mutation other = (Mutation) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}
	
	public boolean sameIdentityAs(Mutation other) {
		return this.equals(other);
	}
}
