/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.svc;
import com.mycompany.belajarcrud.domain.CNB;
import com.mycompany.belajarcrud.domain.CNBItem;
import com.mycompany.belajarcrud.domain.assembler.CNBAssembler;
import com.mycompany.belajarcrud.domain.assembler.CNBItemAssembler;
import com.mycompany.belajarcrud.domain.assembler.PayrollAssembler;
import com.mycompany.belajarcrud.domain.repository.CNBItemRepository;
import com.mycompany.belajarcrud.domain.repository.CNBRepository;
import com.mycompany.belajarcrud.dto.CNBDTO;
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
 * @author William
 */
@RestController
@Slf4j
public class CNBRESTController {
    @Autowired
    CNBRepository cnbRepository;
    
    @Autowired
    CNBItemRepository cNBItemRepository;

    @RequestMapping(value = "/get.cnb.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> getCNBDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new CNBDTO().getInstance());
    }

    @RequestMapping(value = "/get.cnb.by.empID/{empID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> getCNBByempID(@PathVariable("empID") String empID) {
        CNB data = (CNB) cnbRepository.findOneByEmpID(empID);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new CNBAssembler().toDTO(data));
    }

    @RequestMapping(value = "/post.cnb",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> postCNB(@RequestBody CNBDTO cnbDTO) {
        CNB cnb = new CNBAssembler().toDomain(cnbDTO);
        cnb.setCnbItems(new CNBItemAssembler().toDomains(cnbDTO.getCnbItemsDTOs()));
        cnb.setSalary(new PayrollAssembler().toDomain(cnbDTO.getSalary()));
//        List<CNBItem> cnbItems = new ArrayLis
//        cnbRepository.save(new CNBAssembler().toDomain(cnbDTO));
    
// cnbRepository.save(new CNBAssembler().toDomain(cnbDTO));
        cnbRepository.save(cnb);
        return ResponseEntity.status(HttpStatus.CREATED).body(cnbDTO);
    }

    @RequestMapping(value = "/update.cnb",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> updateCNB(@RequestBody CNBDTO cnbDTO) {
        CNB cnb = (CNB) cnbRepository.findOneByEmpID(cnbDTO.getEmpID());
        cnb.setEmpID(cnbDTO.getEmpID());
        cnb.setEmpName(cnbDTO.getEmpName());
        cnb.setCnbItems(new CNBItemAssembler().toDomains(cnbDTO.getCnbItemsDTOs()) );
        cnb.setSalary(new PayrollAssembler().toDomain(cnbDTO.getSalary()));
     //   cnb.setBaseSalary(cnbDTO.getBaseSalary());
        cnbRepository.save(cnb);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CNBAssembler().toDTO(cnb));
    }

    @RequestMapping(value = "/delete.cnb/{empID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCNB(@PathVariable("empID") String empID) {
        CNB cnb = (CNB) cnbRepository.findOneByEmpID(empID);
        cnbRepository.delete(cnb);
        return ResponseEntity.status(HttpStatus.CREATED).body("CNB : " + cnb.getEmpID() + " is Successfully deleted");
    }
}
