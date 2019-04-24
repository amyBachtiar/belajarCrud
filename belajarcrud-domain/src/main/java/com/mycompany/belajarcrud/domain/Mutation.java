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
	
	public Mutation() {
	}
	
	public Mutation( String finalPosition, boolean mutated, String mutationNumber, Date mutationDate, Set<Employee> employees) {
		this.finalPosition = finalPosition;
		this.mutated = mutated;
		this.mutationNumber = mutationNumber;
		this.mutationDate = mutationDate;
                this.employees = employees;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finalPosition == null) ? 0 : finalPosition.hashCode());
		result = prime * result + (mutated ? 1231 : 1237);
		//result = prime * result + ((mutationBatch == null) ? 0 : mutationBatch.hashCode());
		result = prime * result + ((mutationDate == null) ? 0 : mutationDate.hashCode());
		result = prime * result + ((mutationNumber == null) ? 0 : mutationNumber.hashCode());
		//result = prime * result + ((position == null) ? 0 : position.hashCode());
                result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		return result;
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
