package com.mycompany.belajarcrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Objects;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "RECRUITMENT")
public class Recruitment implements EntityObject<Recruitment> {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    
    private String recID; 
    private String recType;
    private boolean status;

    public Recruitment() {
    }

    public Recruitment(String recID, String recType, boolean status) {
        this.recID = recID;
        this.recType = recType;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecID() {
        return recID;
    }

    public void setRecID(String recID) {
        this.recID = recID;
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.recID);
        hash = 47 * hash + Objects.hashCode(this.recType);
        hash = 47 * hash + (this.status ? 1 : 0);
        return hash;
    }
    
    @Override
    public boolean sameIdentityAs(Recruitment other) {
         return this.equals(other);
    }

}
