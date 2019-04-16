package com.mycompany.belajarcrud.domain;

import com.mycompany.belajarcrud.common.EntityObject;
//import java.util.Set;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

/**
 *
 * @author kori
 */

@Entity
@Table(name="MST_ASSESS")
//@Inheritance(strategy=InheritanceType.JOINED)
public class Assessment implements EntityObject<Assessment> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
//    @Column(unique=true)
//    @NotNull(message="part code cannot be null")
    private String empAssessID;
    private int empAssessment;
   
//    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL)
//    @JoinColumn(name="employeeID", nullable=false)
//    private Set<Employee>empIDs;
    
    public Assessment (){}

    public Assessment(Integer id, String empAssessID, int empAssessment/*, Set<Employee> empIDs*/) {
        this.id = id;
        this.empAssessID = empAssessID;
        this.empAssessment = empAssessment;
        //this.empIDs = empIDs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpAssessID() {
        return empAssessID;
    }

    public void setEmpAssessID(String empAssessID) {
        this.empAssessID = empAssessID;
    }

    public int getEmpAssessment() {
        return empAssessment;
    }

    public void setEmpAssessment(int empAssessment) {
        this.empAssessment = empAssessment;
    }

    /*
    public Set<Employee> getEmpIDs() {
        return empIDs;
    }

    public void setEmpIDs(Set<Employee> empIDs) {
        this.empIDs = empIDs;
    }*/

        
    @Override
    public boolean sameIdentityAs(Assessment other) {
        return this.equals(other);
    }
    
            
}
