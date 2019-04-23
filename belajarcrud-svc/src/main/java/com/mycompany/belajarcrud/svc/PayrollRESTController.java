package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Payroll;
import com.mycompany.belajarcrud.domain.Payrollitems;
import com.mycompany.belajarcrud.domain.assembler.PayrollAssembler;
import com.mycompany.belajarcrud.domain.assembler.PayrollitemsAssembler;
import com.mycompany.belajarcrud.domain.repository.PayrollRepository;
import com.mycompany.belajarcrud.domain.repository.PayrollitemsRepository;
import com.mycompany.belajarcrud.dto.PayrollDTO;
import com.mycompany.belajarcrud.dto.PayrollitemsDTO;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
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
 * @author Nadya
 */

@RestController
@Slf4j
public class PayrollRESTController {
    
    @Autowired
    PayrollRepository payrollRepository;
    
    @Autowired
    PayrollitemsRepository payrollitemsRepository;
    
   
    @RequestMapping(value = "/get.payroll.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollDTO> getPayrollDummy(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new PayrollDTO().getInstance());
    }
    
    @RequestMapping(value = "/get.payroll.by.payrollID/{payrollID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollDTO> getPayrollByPayrollID(@PathVariable("payrollID")String payrollID){
        Payroll data = payrollRepository.findOneByPayrollID(payrollID);
        if(data == null){
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new PayrollAssembler().toDTO(data));
    }
    
    @RequestMapping(value = "/post.payroll",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollDTO>postPayroll(@RequestBody PayrollDTO payrollDTO){
        Payroll payroll = new PayrollAssembler().toDomain(payrollDTO);
        payrollRepository.save(payroll);
        return ResponseEntity.status(HttpStatus.CREATED).body(payrollDTO);
    }
    
    @RequestMapping(value = "/update.payroll",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollDTO> updatePayroll(@RequestBody PayrollDTO payrollDTO){
        Payroll payroll = (Payroll) payrollRepository.findOneByPayrollID(payrollDTO.getPayrollID());
        payroll.setPayrollID(payrollDTO.getPayrollID());
        payroll.setBaseSalary(payrollDTO.getBaseSalary());
        payroll.setTotalPayroll(payrollDTO.getTotalPayroll());
        Set<Payrollitems> payrollitemses = new HashSet<Payrollitems>();
        for (PayrollitemsDTO adto : payrollDTO.getPayItemsDTOs()){
            Payrollitems payrollitems = payrollitemsRepository.findOneByPayrollitemsID(adto.getPayrollitemsID());
            if(payrollitems != null){
                payrollitems.setPayrollDate(adto.getPayrollDate());
                payrollitems.setPayrollitemsAmmount(adto.getPayrollitemsAmmount());
                payrollitems.setPayrollitemsID(adto.getPayrollitemsID());
                payrollitems.setPayrollitemsName(adto.getPayrollitemsName());
                payrollitemses.add(payrollitems);
            } else {
                Payrollitems a = new PayrollitemsAssembler().toDomain(adto);
                payrollitemses.add(a);
            }
        }
        payroll.setPayItems(payrollitemses);
        payrollRepository.save(payroll);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PayrollAssembler().toDTO(payroll));
    }
    
    @RequestMapping(value = "/delete.payroll/{payrollID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePasyroll(@PathVariable("payrollID") String payrollID){
        Payroll payroll = (Payroll) payrollRepository.findOneByPayrollID(payrollID);
        payrollRepository.delete(payroll);
        return ResponseEntity.status(HttpStatus.CREATED).body("Payroll : " + payroll.getPayrollID()+ " is Succesfully deleted");
    }
            
}
