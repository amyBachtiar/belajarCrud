/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Bizpar;
import com.mycompany.belajarcrud.domain.CNBItem;
import com.mycompany.belajarcrud.domain.assembler.BizparAssembler;
import com.mycompany.belajarcrud.domain.assembler.CNBItemAssembler;
import com.mycompany.belajarcrud.domain.repository.BizparRepository;
import com.mycompany.belajarcrud.domain.repository.CNBItemRepository;
import com.mycompany.belajarcrud.domain.repository.CNBRepository;
import com.mycompany.belajarcrud.dto.BizparDTO;
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
public class CNBItemRESTController {
   @Autowired
    CNBItemRepository cnbitemRepository;
   @Autowired
   CNBRepository cnbRepository;

    @RequestMapping(value = "/get.cnbitem.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBItemDTO> getCNBItemDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new CNBItemDTO().getInstance());
    }

    @RequestMapping(value = "/get.cnbitem.by.empID/{empID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBItemDTO> getCNBItemByempID(@PathVariable("CnBempID") String CnBempID) {
        CNBItem data = (CNBItem) cnbitemRepository.findOneByCnBempID(CnBempID);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new CNBItemAssembler().toDTO(data));
    }

    @RequestMapping(value = "/post.cnbitem",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBItemDTO> postCNBItem(@RequestBody CNBItemDTO cnbitemDTO) {
        CNBItem cnbitems = new CNBItemAssembler().toDomain(cnbitemDTO);
        cnbitemRepository.save(cnbitems);
//        cnbitemRepository.save(new CNBItemAssembler().toDomain(cnbitemDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(cnbitemDTO);
    }

    @RequestMapping(value = "/update.cnbitem",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CNBItemDTO> updateCNBItem(@RequestBody CNBItemDTO cnbitemDTO) {
        CNBItem cnbitem = (CNBItem) cnbitemRepository.findOneByCnBempID(cnbitemDTO.getCnBempID());
//        cnbitem.setBaseSalary(cnbitemDTO.getBaseSalary());
        cnbitem.setInsurance(cnbitemDTO.getInsurance());
        cnbitem.setPensiun(cnbitemDTO.getPensiun());
        cnbitemRepository.save(cnbitem);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CNBItemAssembler().toDTO(cnbitem));
    }

    @RequestMapping(value = "/delete.cnbitem/{empID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCNBItem(@PathVariable("CnBempID") String CnBempID) {
        CNBItem cnbitem = (CNBItem) cnbitemRepository.findOneByCnBempID(CnBempID);
        cnbitemRepository.delete(cnbitem);
        return ResponseEntity.status(HttpStatus.CREATED).body("cnbitems : " + cnbitem.getcnBempID() + " is Successfully deleted");
    } 
}
