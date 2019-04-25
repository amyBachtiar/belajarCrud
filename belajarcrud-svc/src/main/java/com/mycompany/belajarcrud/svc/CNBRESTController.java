/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.CNB;
import com.mycompany.belajarcrud.domain.CNBItem;
import com.mycompany.belajarcrud.domain.Employee;
import com.mycompany.belajarcrud.domain.assembler.CNBAssembler;
import com.mycompany.belajarcrud.domain.assembler.CNBItemAssembler;
import com.mycompany.belajarcrud.domain.repository.CNBItemRepository;
import com.mycompany.belajarcrud.domain.repository.CNBRepository;
import com.mycompany.belajarcrud.domain.repository.EmployeeRepository;

import com.mycompany.belajarcrud.dto.CNBDTO;
import com.mycompany.belajarcrud.dto.CNBItemDTO;
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
 * @author eksad-edwina
 */
@RestController
@Slf4j
public class CNBRESTController {
    @Autowired
    CNBRepository cnbRepository;
    
    @Autowired
    CNBItemRepository cnbitemRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    
    @RequestMapping(value = "/get.cnb.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> getCNBDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new CNBDTO().getInstance());
    }

    @RequestMapping(value = "/get.cnb.by.empID/{empID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> getCNBByempID(@PathVariable("cnbID") String cnbID) {
        CNB data = (CNB) cnbRepository.findOneByCnbID(cnbID);
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
        cnb.setEmployee(employeeRepository.findOneByEmpId(cnbDTO.getEmployeeDTO().getEmpId()));//
        cnbRepository.save(new CNBAssembler().toDomain(cnbDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(cnbDTO);
    }

    @RequestMapping(value = "/update.cnb",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBDTO> updateCNB(@RequestBody CNBDTO cnbDTO) {
        CNB cnb = (CNB) cnbRepository.findOneByCnbID(cnbDTO.getCnbID());
        cnb.setCnbID(cnbDTO.getCnbID());
        cnb.setCnbStatus(cnbDTO.isCnbStatus());
        cnb.setCnbDesc(cnbDTO.getCnbDesc());
        Set<CNBItem> cnbitems = new HashSet<CNBItem>();
            for(CNBItemDTO itemsDTO : cnbDTO.getCnbItemsDTOs()){
                CNBItem cnbitem = cnbitemRepository.findOneByCnbitemID(itemsDTO.getCnbitemID());
                if(cnbitem != null){
                    cnbitems.add(cnbitem);
                }else{
                    CNBItem item = new CNBItemAssembler().toDomain(itemsDTO);
                    cnbitems.add(item);
                }
            }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(new CNBAssembler().toDTO(cnb));
    }

    @RequestMapping(value = "/delete.cnb/{empID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCNB(@PathVariable("cnbID") String cnbID) {
        CNB cnb = (CNB) cnbRepository.findOneByCnbID(cnbID);
        cnbRepository.delete(cnb);
        return ResponseEntity.status(HttpStatus.CREATED).body("CNB : " + cnb.getCnbID() + " is Successfully deleted");
    }
}