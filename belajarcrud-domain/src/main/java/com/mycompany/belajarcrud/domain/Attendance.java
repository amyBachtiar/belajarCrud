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
 * @author noldyy
 */
@Entity
@Table(name = "MST_ATTENDANCE")
public class Attendance implements EntityObject<Attendance> {

    /**
     * Hibernate purpose
     */ 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    private String code;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timeIn;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timeOut;

    public Attendance() {
    }

    public Attendance(String code, Date date, Date timeIn, Date timeOut) {
        this.code = code;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }
    
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
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
        final Attendance other = (Attendance) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.code);
        hash = 17 * hash + Objects.hashCode(this.date);
        hash = 17 * hash + Objects.hashCode(this.timeIn);
        hash = 17 * hash + Objects.hashCode(this.timeOut);
        return hash;
    }

	@Override
	public boolean sameIdentityAs(Attendance other) {
		// TODO Auto-generated method stub
		return this.equals(other);
	}
}
