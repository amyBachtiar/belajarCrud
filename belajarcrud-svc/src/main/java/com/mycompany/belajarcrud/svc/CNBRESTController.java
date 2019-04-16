/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Bizpar;
import com.mycompany.belajarcrud.domain.CNB;
import com.mycompany.belajarcrud.domain.CNBItem;
import com.mycompany.belajarcrud.domain.assembler.BizparAssembler;
import com.mycompany.belajarcrud.domain.assembler.CNBAssembler;
import com.mycompany.belajarcrud.domain.assembler.CNBItemAssembler;
import com.mycompany.belajarcrud.domain.repository.BizparRepository;
import com.mycompany.belajarcrud.domain.repository.CNBItemRepository;
import com.mycompany.belajarcrud.domain.repository.CNBRepository;
import com.mycompany.belajarcrud.dto.BizparDTO;
import com.mycompany.belajarcrud.dto.CNBDTO;
import com.mycompany.belajarcrud.dto.CNBItemDTO;
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
 * @author eksad-edwina
 */

@RestController
@Slf4j
public class CNBRESTController {
   @Autowired
    CNBRepository cnbRepository;

    @RequestMapping(value = "/get.cnb.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> getCNBDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new CNBDTO().getInstance());
    }

    @RequestMapping(value = "/get.cnb.by.empName/{empName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> getCNBByempID(@PathVariable("empName") String empName) {
        CNB data = (CNB) cnbRepository.findOneByEmpName(empName);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new CNBAssembler().toDTO(data));
    }

    @RequestMapping(value = "/post.cnb",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> postCNBItem(@RequestBody CNBDTO cnbDTO) {
        cnbRepository.save(new CNBAssembler().toDomain(cnbDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(cnbDTO);
    }

    @RequestMapping(value = "/update.cnb",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> updateCNBItem(@RequestBody CNBDTO cnbDTO) {
        CNB cnb = (CNB) cnbRepository.findOneByEmpName(cnbDTO.getEmpName());
        cnb.setBaseSalary(cnbDTO.getBaseSalary());
        cnb.setEmpID(cnbDTO.getEmpID());
        cnbRepository.save(cnb);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CNBAssembler().toDTO(cnb));
    }

    @RequestMapping(value = "/delete.cnb/{Name}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCNB(@PathVariable("empName") String empName) {
        CNB cnb = (CNB) cnbRepository.findOneByEmpName(empName);
        cnbRepository.delete(cnb);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bizpar : " + cnb.getEmpName() + " is Successfully deleted");
    } 
}
