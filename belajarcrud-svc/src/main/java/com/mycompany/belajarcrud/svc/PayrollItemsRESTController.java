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
import com.mycompany.belajarcrud.dto.PayrollDTO;
import com.mycompany.belajarcrud.dto.PayrollItemsDTO;
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
    public ResponseEntity<PayrollItemsDTO>postPayrollItems(@RequestBody PayrollItemsDTO payrollItemsDTO){
        payrollItemsRepository.save(new PayrollItemsAssembler().toDomain(payrollItemsDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(payrollItemsDTO);
}
}