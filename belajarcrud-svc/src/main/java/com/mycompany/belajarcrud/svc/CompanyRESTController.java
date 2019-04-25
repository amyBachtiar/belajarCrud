/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.svc;
 
import com.mycompany.belajarcrud.domain.Company;
import com.mycompany.belajarcrud.domain.Employee;
import com.mycompany.belajarcrud.domain.Jobdesc;
import com.mycompany.belajarcrud.domain.assembler.CompanyAssembler;
import com.mycompany.belajarcrud.domain.assembler.EmployeeAssembler;
import com.mycompany.belajarcrud.domain.assembler.JobdescAssembler;
import com.mycompany.belajarcrud.domain.repository.AssessmentRepository;
import com.mycompany.belajarcrud.domain.repository.CompanyRepository;
import com.mycompany.belajarcrud.domain.repository.EmployeeRepository;
import com.mycompany.belajarcrud.domain.repository.JobdescRepository;
import com.mycompany.belajarcrud.domain.repository.MutationRepository;
import com.mycompany.belajarcrud.domain.repository.RecruitmentRepository;
import com.mycompany.belajarcrud.dto.CompanyDTO;
import com.mycompany.belajarcrud.dto.CompanySinglePostDTO;
import com.mycompany.belajarcrud.dto.EmployeeDTO;
import com.mycompany.belajarcrud.dto.JobdescDTO;
import java.util.HashSet;
import java.util.Set;
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
 * @author amelia
 */
@RestController
public class CompanyRESTController {

@Autowired
CompanyRepository companyRepository;

@Autowired
JobdescRepository jobdescRepository;

@Autowired
MutationRepository mutationRepository;

@Autowired
RecruitmentRepository recruitmentRepository;

@Autowired
EmployeeRepository employeeRepository;


@RequestMapping(value = "/get.company.dummy",
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<CompanyDTO>getCompanyDummy(){
    return ResponseEntity.status(HttpStatus.FOUND).body(new CompanyDTO().getInstance());
}

 @RequestMapping(value="/get.company.by.companyID/{companyID}",
           method=RequestMethod.GET,
           produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDTO>getCompanyByCompanyId(@PathVariable("companyID") String companyID){
        Company data=companyRepository.findOneByCompanyID(companyID);
            if(data==null){
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new CompanyAssembler().toDTO(data));
        }
    
    @RequestMapping(value = "/post.company",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanySinglePostDTO> postCompany(@RequestBody CompanySinglePostDTO companySinglePostDTO) {
        Company company = new CompanyAssembler().toDomain(companySinglePostDTO);
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(companySinglePostDTO);
    }
    
    @RequestMapping(value="/update.company",
            method=RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanySinglePostDTO companyDTO) {
        Company company = (Company) companyRepository.findOneByCompanyID(companyDTO.getCompanyID());
        company.setCompanyID(companyDTO.getCompanyID());
        company.setCompanyName(companyDTO.getCompanyName());
        company.setCompanyAdd(companyDTO.getCompanyAdd());
        company.setCompanyPhone(companyDTO.getCompanyPhone());
        company.setCompanyDesc(companyDTO.getCompanyDesc());
        
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CompanyAssembler().toDTO(company));
    }
    
    @RequestMapping(value = "/delete.company/{companyID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCompany(@PathVariable("companyID") String companyID) {
        Company company = (Company) companyRepository.findOneByCompanyID(companyID);
        companyRepository.delete(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company : " + company.getCompanyID() + " is Successfully deleted");
    }

}