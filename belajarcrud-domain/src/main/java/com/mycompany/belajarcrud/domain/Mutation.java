package com.mycompany.belajarcrud.domain;

/**
 *
 * @author tika
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_mutation")
public class Mutation implements EntityObject<Mutation> {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	private String empID;
	private String empName;
	private String position;
	private String finalPosition;
	private boolean mutated;
	private String mutationNumber;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
	private Date mutationDate;
	//private String mutationBatch;
	
	public Mutation() {
	}
	
	public Mutation(String empID, String empName, String position, String finalPosition, boolean mutated, String mutationNumber, Date mutationDate, String mutationBatch) {
		this.empID = empID;
		this.empName = empName;
		this.position = position;
		this.finalPosition = finalPosition;
		this.mutated = mutated;
		this.mutationNumber = mutationNumber;
		this.mutationDate = mutationDate;
		//this.mutationBatch = mutationBatch;
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
		result = prime * result + ((empID == null) ? 0 : empID.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((finalPosition == null) ? 0 : finalPosition.hashCode());
		result = prime * result + (mutated ? 1231 : 1237);
		//result = prime * result + ((mutationBatch == null) ? 0 : mutationBatch.hashCode());
		result = prime * result + ((mutationDate == null) ? 0 : mutationDate.hashCode());
		result = prime * result + ((mutationNumber == null) ? 0 : mutationNumber.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
