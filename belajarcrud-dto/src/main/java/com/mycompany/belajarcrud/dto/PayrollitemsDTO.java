
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

/**
 *
 * @author Nadya
 */
public class PayrollitemsDTO {
    
    private String payrollitemsID;
    private double bonusSalary;
    private double totalBonus;
    private double totalTax;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
    private Date payrollDate;  

    public String getPayrollitemsID() {
        return payrollitemsID;
    }

    public void setPayrollitemsID(String payrollitemsID) {
        this.payrollitemsID = payrollitemsID;
    }

    public double getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(double bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public double getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(double totalBonus) {
        this.totalBonus = totalBonus;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public Date getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(Date payrollDate) {
        this.payrollDate = payrollDate;
    }
    
    //create data dummy
    @JsonIgnore
    public PayrollitemsDTO getInstance(){
        PayrollitemsDTO dto = new PayrollitemsDTO();
        dto.setPayrollitemsID("P-ID-001");
        dto.setBonusSalary(200000);
        dto.setTotalBonus(400000);
        dto.setTotalTax(500000);
        Date pay = new Date();
        dto.setPayrollDate(pay);
        return dto;
    }
}
