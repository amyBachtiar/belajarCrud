/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Payroll;
import com.mycompany.belajarcrud.domain.assembler.PayrollAssembler;
import com.mycompany.belajarcrud.domain.assembler.PayrollItemsAssembler;
import com.mycompany.belajarcrud.domain.repository.PayrollRepository;
import com.mycompany.belajarcrud.dto.PayrollDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DanielCABN
 */

@RestController
public class PayrollRESTController {
    
    @Autowired
    PayrollRepository payrollRepository;
    
    @RequestMapping(value="/payroll.dummy", 
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <PayrollDTO> getPayrollDumy(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new PayrollDTO().getInstance());
        
    }
     @RequestMapping(value = "/payroll/{payrollID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollDTO> getPayrollByPayrollID(@PathVariable("payrollID")String payrollID){
        Payroll data = payrollRepository.findOneByPayrollID(payrollID);
        if(data == null){
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new PayrollAssembler().toDTO(data));
}
    
    @RequestMapping(value = "/payroll",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollDTO>postPayroll(@RequestBody PayrollDTO payrollDTO){       
       // Payroll payroll = new PayrollAssembler().toDomain(payrollDTO);
        //payroll.setPayItems(new PayrollItemsAssembler().toDomains(payrollDTO.getPayItems()));
        payrollRepository.save(new PayrollAssembler().toDomain(payrollDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(payrollDTO);
}
    @RequestMapping(value = "/payroll",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollDTO> updatePayroll(@RequestBody PayrollDTO payrollDTO){
        Payroll payroll = (Payroll) payrollRepository.findOneByPayrollID(payrollDTO.getPayrollID());
        payroll.setPayrollID(payrollDTO.getPayrollID());
        payroll.setBaseSalary(payrollDTO.getBaseSalary());
        payroll.setTotalPayroll(payrollDTO.getTotalPayroll());
        payrollRepository.save(payroll);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PayrollAssembler().toDTO(payroll));
}
     @RequestMapping(value = "/payroll/{payrollID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePayroll(@PathVariable("payrollID") String payrollID){
        Payroll payroll = (Payroll) payrollRepository.findOneByPayrollID(payrollID);
        payrollRepository.delete(payroll);
        return ResponseEntity.status(HttpStatus.CREATED).body("Payroll : " + payroll.getPayrollID()+ " is Succesfully deleted");
}
}
