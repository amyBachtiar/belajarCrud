/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain;

import com.eksad.ddms.common.util.object.EntityObject;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
/**
 *
 * @author amel
 */
@Entity
@Table(name = "MST_COMP")
public class Company implements EntityObject<Company>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String companyID;
    private String companyName;
    private String companyAdd;
    private String companyPhone;
    private String companyDesc;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name =  "companyID", referencedColumnName = "companyID")
    private Set<Employee> employees;

    public Company() {
    }

    public Company(String companyID, String companyName, String companyAdd, String companyPhone, String companyDesc, Set<Employee> employees) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyAdd = companyAdd;
        this.companyPhone = companyPhone;
        this.companyDesc = companyDesc;
        this.employees = employees;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAdd() {
        return companyAdd;
    }

    public void setCompanyAdd(String companyAdd) {
        this.companyAdd = companyAdd;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.companyID);
        hash = 37 * hash + Objects.hashCode(this.companyName);
        hash = 37 * hash + Objects.hashCode(this.companyAdd);
        hash = 37 * hash + Objects.hashCode(this.companyPhone);
        hash = 37 * hash + Objects.hashCode(this.companyDesc);
        hash = 37 * hash + Objects.hashCode(this.employees);
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
        final Company other = (Company) obj;
        return true;
    }
    
    @Override
    public boolean sameIdentityAs(Company other) {
        return this.equals(other);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
