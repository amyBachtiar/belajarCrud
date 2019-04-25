
package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Company;
import com.mycompany.belajarcrud.domain.Jobdesc;
import com.mycompany.belajarcrud.domain.assembler.CompanyAssembler;
import com.mycompany.belajarcrud.domain.assembler.JobdescAssembler;
import com.mycompany.belajarcrud.domain.repository.CompanyRepository;
import com.mycompany.belajarcrud.domain.repository.JobdescRepository;
import com.mycompany.belajarcrud.dto.JobdescDTO;
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
 * @author desi
 */

@RestController
@Slf4j
public class JobdescRESTController {
    
    @Autowired
    JobdescRepository jobdescRepository;
    
    @Autowired
    CompanyRepository companyRepository;
    
    @RequestMapping(value = "/get.jobdesc.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobdescDTO> getJobdescDummy(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new JobdescDTO().getInstance());
    }
    
    @RequestMapping(value = "/get.jobdesc.by.jobdescid/{jobdescId}", 
            method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobdescDTO> getAttendanceByEmpId(@PathVariable("jobdescId") String jobdescId){
        Jobdesc data = jobdescRepository.findOneByJobdescId(jobdescId);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new JobdescAssembler().toDTO(data));
    }
    
    @RequestMapping(value = "/post.jobdesc",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobdescDTO> postJobdesc (@RequestBody JobdescDTO jobdescDTO){
          Jobdesc jobdesc =  jobdescRepository.findOneByJobdescId(jobdescDTO.getJobdescId());
//        
//        if(company.getJobdescs() != null && company.getJobdescs().size() > 0){
//            company.getJobdescs().add(new JobdescAssembler().toDomain(cusDTO.getJobds()));
//        }else{
//            company.setJobdescs(new HashSet<Jobdesc>(Arrays.asList(new JobdescAssembler().toDomain(cusDTO.getJobds()))));
//        }
        jobdesc.setCompany(companyRepository.findOneByCompanyID(jobdescDTO.getCompanyID()));
        jobdescRepository.save(new JobdescAssembler().toDomain(jobdescDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(jobdescDTO);
    }
    
    @RequestMapping(value = "/update.jobdesc",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobdescDTO> updateJobdesc(@RequestBody JobdescDTO jobdescDTO){
        Jobdesc jobdesc = (Jobdesc) jobdescRepository.findOneByJobdescId(jobdescDTO.getJobdescId());
        jobdesc.setJobdescId(jobdescDTO.getJobdescId());
        jobdesc.setName(jobdescDTO.getName());
        jobdesc.setDescription(jobdescDTO.getDescription());
//        jobdescRepository.save(jobdesc);
        return ResponseEntity.status(HttpStatus.CREATED).body(new JobdescAssembler().toDTO(jobdesc));
    }
    
    @RequestMapping(value = "/delete.jobdesc/{jobdescId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteJobdesc(@PathVariable("jobdescId") String jobdescId){
        Jobdesc jobdesc = (Jobdesc) jobdescRepository.findOneByJobdescId(jobdescId);
        jobdescRepository.delete(jobdesc);
        return ResponseEntity.status(HttpStatus.CREATED).body("Jobdesc : " + jobdesc.getJobdescId() + " is Succesfully deleted");
    }
}