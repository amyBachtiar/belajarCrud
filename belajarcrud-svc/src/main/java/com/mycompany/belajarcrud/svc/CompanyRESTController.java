package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Company;
import com.mycompany.belajarcrud.domain.assembler.CompanyAssembler;
import com.mycompany.belajarcrud.dto.CompanyDTO;
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
import com.mycompany.belajarcrud.domain.repository.CompanyRepository;

/**
 *
 * @author Mega
 */
@RestController
@Slf4j
public class CompanyRESTController {
    
    @Autowired
    CompanyRepository companyRepository;
    
    @RequestMapping(value="/get.company.dummy",
            method=RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDTO>getCompanyDummy(){
            return ResponseEntity.status(HttpStatus.FOUND).body(new CompanyDTO().getInstance());
    }
    
    @RequestMapping(value="/get.company.by.companyId/{companyId}",
           method=RequestMethod.GET,
           produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDTO>getCompanyByCompanyId(@PathVariable("companyId") String companyId){
        Company data=companyRepository.findOneByCompanyId(companyId);
        if(data==null){
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new CompanyAssembler().toDTO(data));
        }
    
    @RequestMapping(value = "/post.company",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDTO> postCompany(@RequestBody CompanyDTO companyDTO) {
        companyRepository.save(new CompanyAssembler().toDomain(companyDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(companyDTO);
    }
    
    @RequestMapping(value="/update.company",
            method=RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO) {
        Company company = (Company) companyRepository.findOneByCompanyId(companyDTO.getCompanyId());
        company.setCompanyId(companyDTO.getCompanyId());
        company.setCompanyName(companyDTO.getCompanyName());
        company.setCompanyDesc(companyDTO.getCompanyDesc());
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CompanyAssembler().toDTO(company));
    }
    
    @RequestMapping(value = "/delete.company/{companyId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCompany(@PathVariable("companyId") String companyId) {
        Company company = (Company) companyRepository.findOneByCompanyId(companyId);
        companyRepository.delete(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company : " + company.getCompanyId() + " is Successfully deleted");
    }
}
