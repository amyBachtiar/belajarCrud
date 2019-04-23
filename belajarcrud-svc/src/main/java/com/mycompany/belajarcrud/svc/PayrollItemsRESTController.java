/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Payroll;
import com.mycompany.belajarcrud.domain.PayrollItems;
import com.mycompany.belajarcrud.domain.assembler.PayrollAssembler;
import com.mycompany.belajarcrud.domain.assembler.PayrollItemsAssembler;
import com.mycompany.belajarcrud.domain.repository.PayrollItemsRepository;
import com.mycompany.belajarcrud.domain.repository.PayrollRepository;
import com.mycompany.belajarcrud.dto.PayrollDTO;
import com.mycompany.belajarcrud.dto.PayrollItemsDTO;
import com.mycompany.belajarcrud.dto.customDTO;
import java.util.Arrays;
import java.util.HashSet;
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
public class PayrollItemsRESTController {
    @Autowired
    PayrollItemsRepository payrollItemsRepository;
    
    @Autowired
    PayrollRepository payrollRepository;
    
      @RequestMapping(value="/get.payrollitems.dummy", 
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <PayrollItemsDTO> getPayrollItemDumy(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new PayrollItemsDTO().getInstance());
        
    }
    @RequestMapping(value = "/payrollitems/{payrollID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollItemsDTO> getPayrollByPayrollItemsID(@PathVariable("payrollItemsID")String payrollItemsID){
        PayrollItems data = payrollItemsRepository.findOneByPayrollItemsID(payrollItemsID);
        if(data == null){
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new PayrollItemsAssembler().toDTO(data));
}
    @RequestMapping(value = "/payrollitems",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollItemsDTO>postPayrollItems(@RequestBody customDTO cusDTO){

        Payroll payroll=(Payroll) payrollRepository.findOneByPayrollID(cusDTO.getPayrollID());
        
        if(payroll.getPayItems() != null && payroll.getPayItems().size() > 0){
            payroll.getPayItems().add(new PayrollItemsAssembler().toDomain(cusDTO.getPayrollIT()));
        }else {
            payroll.setPayItems(new HashSet<PayrollItems>(Arrays.asList(new PayrollItemsAssembler().toDomain(cusDTO.getPayrollIT()))));
        }
        
        payrollRepository.save(payroll);
//        payrollItemsRepository.save(new PayrollItemsAssembler().toDomain(payrollItemsDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(cusDTO.getPayrollIT());
}
    @RequestMapping(value = "/payrollitems",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollItemsDTO> updatePayrollItems(@RequestBody PayrollItemsDTO payrollItemsDTO){
        PayrollItems payrollItems = (PayrollItems) payrollItemsRepository.findOneByPayrollItemsID(payrollItemsDTO.getPayrollItemsID());
        payrollItems.setPayrollItemsID(payrollItemsDTO.getPayrollItemsID());
        payrollItems.setBonusSalary(payrollItemsDTO.getBonusSalary());
        payrollItems.setTotalBonus(payrollItemsDTO.getTotalBonus());
        payrollItems.setPayrollItemsDate(payrollItemsDTO.getPayrollItemsDate());
        payrollItems.setTotalTax(payrollItemsDTO.getTotalTax());
        payrollItemsRepository.save(payrollItems);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PayrollItemsAssembler().toDTO(payrollItems));
}
    
}