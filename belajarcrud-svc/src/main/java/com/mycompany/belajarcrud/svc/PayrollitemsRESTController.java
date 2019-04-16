
package com.mycompany.belajarcrud.svc;



import com.mycompany.belajarcrud.domain.Payrollitems;
import com.mycompany.belajarcrud.domain.assembler.PayrollitemsAssembler;
import com.mycompany.belajarcrud.domain.repository.PayrollRepository;
import com.mycompany.belajarcrud.domain.repository.PayrollitemsRepository;
import lombok.extern.slf4j.Slf4j;
import com.mycompany.belajarcrud.dto.PayrollitemsDTO;
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
public class PayrollitemsRESTController {
    
    @Autowired
    PayrollitemsRepository payrollitemsRepository;
    
    @Autowired
    PayrollRepository payrollRepository;
    
    @RequestMapping(value = "/get.payrollitems.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollitemsDTO> getPayrollitemsDummy(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new PayrollitemsDTO().getInstance());
    }
    
    @RequestMapping(value = "/get.payrollitems.by.payrollitemsID/{payrollitemsID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollitemsDTO> getPayrollitemsByPayrollitemsID(@PathVariable("payrollitemsID")String payrollitemsID){
        Payrollitems data =  payrollitemsRepository.findOneByPayrollitemsID(payrollitemsID);
        if(data == null){
            return ResponseEntity.status(HttpStatus.FOUND).body(null);   
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new PayrollitemsAssembler().toDTO(data));
    }
    
    @RequestMapping(value = "/post.payrollitems",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollitemsDTO>postPayrollitems(@RequestBody PayrollitemsDTO payrollitemsDTO){
        Payrollitems payrollitems = new PayrollitemsAssembler().toDomain(payrollitemsDTO);
        payrollitems.setPayroll(payrollRepository.findOneByPayrollID(payrollitemsDTO.getPayrollID()));
        payrollitemsRepository.save(payrollitems);
        return ResponseEntity.status(HttpStatus.CREATED).body(payrollitemsDTO);
    }
        
    @RequestMapping(value = "/update.payrollitems",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollitemsDTO> updatePayrollitems(@RequestBody PayrollitemsDTO payrollitemsDTO){
        Payrollitems payrollitems = (Payrollitems) payrollitemsRepository.findOneByPayrollitemsID(payrollitemsDTO.getPayrollitemsID());
        payrollitems.setPayrollitemsID(payrollitemsDTO.getPayrollitemsID());
        payrollitems.setPayrollitemsName(payrollitemsDTO.getPayrollitemsName());
        payrollitems.setPayrollitemsAmmount(payrollitemsDTO.getPayrollitemsAmmount());
        payrollitems.setPayroll(payrollRepository.findOneByPayrollID(payrollitemsDTO.getPayrollID()));
        payrollitemsRepository.save(payrollitems);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PayrollitemsAssembler().toDTO(payrollitems));
    }
    
    @RequestMapping(value = "/delete.payrollitems/{payrollID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePayrollitems(@PathVariable("payrollID") String payrollitemsID){
        Payrollitems payrollitems = (Payrollitems) payrollitemsRepository.findOneByPayrollitemsID(payrollitemsID);
        payrollitemsRepository.delete(payrollitems);
        return ResponseEntity.status(HttpStatus.CREATED).body("Payroll items: " + payrollitems.getPayrollitemsID()+ " is Succesfully deleted");
    }
            
            
    
}
