
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
    private String payrollitemsName;
    private double payrollitemsAmmount;
    
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss a zzz")
    private Date payrollDate;  

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

   

   
    //create data dummy
    @JsonIgnore
    public PayrollitemsDTO getInstance(){
        PayrollitemsDTO dto = new PayrollitemsDTO();
        dto.setPayrollitemsID("P-ID-001");
        dto.setPayrollitemsName("Tax or Bonus?");
        dto.setPayrollitemsAmmount(400000);
        Date pay = new Date();
        dto.setPayrollDate(pay);
       
        return dto;
    }
}
