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
    
    @RequestMapping(value="/get.company.by.company/{companyName}",
           method=RequestMethod.GET,
           produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDTO>getCompanyByCompanyName(@PathVariable("companyName") String companyName){
        Company data=companyRepository.findOneByCompanyName(companyName);
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
        Company company = (Company) companyRepository.findOneByCompanyName(companyDTO.getCompanyName());
        company.setCompanyName(companyDTO.getCompanyName());
        company.setCompanyDesc(companyDTO.getCompanyDesc());
        return ResponseEntity.status(HttpStatus.CREATED).body(new CompanyAssembler().toDTO(company));
    }
    
    @RequestMapping(value = "/delete.company/{companyName}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCompany(@PathVariable("companyName") String companyName) {
        Company company = (Company) companyRepository.findOneByCompanyName(companyName);
        companyRepository.delete(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company : " + company.getCompanyName() + " is Successfully deleted");
    }
}
