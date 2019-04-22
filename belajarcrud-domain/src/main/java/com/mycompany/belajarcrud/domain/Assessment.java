package com.mycompany.belajarcrud.domain;

import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kori
 */

@Entity
@Table(name="MST_ASSESSMENT")
public class Assessment implements EntityObject<Assessment> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(unique=true)
    @NotNull(message="part code cannot be null")
    private String empAssessID;
    private int empAssessment;
  //  private String employeeId;
   
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="employassessId", referencedColumnName="empAssessID")

    private Set<Employee> employIds;
    

    
    public Assessment (){
    }

    public Assessment(String empAssessID, int empAssessment, Set<Employee> employIds) {
        this.empAssessID = empAssessID;
        this.empAssessment = empAssessment;
        this.employIds = employIds;
    }

    public Set<Employee> getEmployIds() {
        return employIds;
    }

    public void setEmployIds(Set<Employee> employIds) {
        this.employIds = employIds;
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
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    */
  
    @Override
    public boolean sameIdentityAs(Assessment other) {
        return this.equals(other);
    }
    
            
}
