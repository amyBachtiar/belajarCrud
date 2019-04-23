package com.mycompany.belajarcrud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mycompany.belajarcrud.common.EntityObject;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

/**
 *
 * @author Nadya
 */

@Entity
@Table(name = "MST_PayrollItems")
public class Payrollitems implements EntityObject<Payrollitems> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    private String payrollitemsID;
    private String payrollitemsName;
    private double payrollitemsAmmount;
    
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
    private Date payrollDate;
   
    
    public Payrollitems(){
    }

    public Payrollitems(String payrollitemsID, String payrollitemsName, double payrollitemsAmmount, Date payrollDate) {
        this.payrollitemsID = payrollitemsID;
        this.payrollitemsName = payrollitemsName;
        this.payrollitemsAmmount = payrollitemsAmmount;
        this.payrollDate = payrollDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayrollitemsID() {
        return payrollitemsID;
    }

    public void setPayrollitemsID(String payrollitemsID) {
        this.payrollitemsID = payrollitemsID;
    }

    public String getPayrollitemsName() {
        return payrollitemsName;
    }

    public void setPayrollitemsName(String payrollitemsName) {
        this.payrollitemsName = payrollitemsName;
    }

    public double getPayrollitemsAmmount() {
        return payrollitemsAmmount;
    }

    public void setPayrollitemsAmmount(double payrollitemsAmmount) {
        this.payrollitemsAmmount = payrollitemsAmmount;
    }

    public Date getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(Date payrollDate) {
        this.payrollDate = payrollDate;
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
        final Payrollitems other = (Payrollitems) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.payrollitemsID);
        hash = 67 * hash + Objects.hashCode(this.payrollitemsName);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.payrollitemsAmmount) ^ (Double.doubleToLongBits(this.payrollitemsAmmount) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.payrollDate);
        return hash;
    }

    @Override
    public boolean sameIdentityAs(Payrollitems other) {
        return this.equals(other);
    }
        
    
}
