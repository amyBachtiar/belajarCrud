package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Company;
import com.mycompany.belajarcrud.domain.Jobseeker;
import com.mycompany.belajarcrud.domain.Recruitment;
import com.mycompany.belajarcrud.domain.assembler.JobseekerAssembler;
import com.mycompany.belajarcrud.domain.assembler.RecruitmentAssembler;
import com.mycompany.belajarcrud.domain.repository.CompanyRepository;
import com.mycompany.belajarcrud.domain.repository.JobseekerRepository;
import com.mycompany.belajarcrud.domain.repository.RecruitmentRepository;
import com.mycompany.belajarcrud.dto.JobseekerDTO;
import com.mycompany.belajarcrud.dto.RecruitmentDTO;
import com.mycompany.belajarcrud.dto.RecruitmentPostDTO;
import java.util.HashSet;
import java.util.List;
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
 * @author SAMSUNG
 */
@RestController
@Slf4j

public class RecruitmentRESTController {
    @Autowired
    RecruitmentRepository recruitmentRepository;
    
     @Autowired
     JobseekerRepository jobseekerRepository;
     
     @Autowired
     CompanyRepository companyRepository;

    @RequestMapping(value = "/get.recruitment.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecruitmentPostDTO> getRecruitmentDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new RecruitmentPostDTO().getInstance());
    }
    
    @RequestMapping(value = "/get.recruitment.by.recID/{recID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecruitmentDTO> getRecruitmentByRecID(@PathVariable("recID") String recID) {
        Recruitment data = recruitmentRepository.findOneByRecID(recID);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new RecruitmentAssembler().toDTO(data));
    }
    
    @RequestMapping(value = "/post.recruitment",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecruitmentPostDTO>postRecruitment(@RequestBody RecruitmentPostDTO recruitmentPostDTO) {
        Recruitment recruitment = new RecruitmentAssembler().toDomain(recruitmentPostDTO);
        Company company = companyRepository.findOneByCompanyId(recruitmentPostDTO.getCompanyId());
        recruitment.setCompany(company);
        recruitmentRepository.save(recruitment);
        return ResponseEntity.status(HttpStatus.CREATED).body(recruitmentPostDTO);
    }

    @RequestMapping(value = "/update.recruitment",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecruitmentPostDTO> updateRecruitment(@RequestBody RecruitmentPostDTO recruitmentPostDTO) {
       Recruitment recruitment = (Recruitment) recruitmentRepository.findOneByRecID(recruitmentPostDTO.getRecID());
    
        recruitment.setRecType(recruitmentPostDTO.getRecType());
        recruitment.setStatus(recruitmentPostDTO.isStatus());
        Set<Jobseeker> jobseekers = recruitment.getJobseekers();
        Set<Jobseeker> newJobSeeker = new HashSet<Jobseeker>();
//        boolean isExsist;
        for (JobseekerDTO recJob : recruitmentPostDTO.getRecJobs()) {
            Jobseeker j = jobseekerRepository.findOneByJobID(recJob.getJobID());
            if(j == null){
                newJobSeeker.add(new JobseekerAssembler().toDomain(recJob));
            } else {
                newJobSeeker.add(j);
            }
        }
        
        recruitment.setJobseekers(newJobSeeker);
            
        recruitmentRepository.save(recruitment);
        return ResponseEntity.status(HttpStatus.CREATED).body(recruitmentPostDTO);
    }

    @RequestMapping(value = "/delete.recruitment/{recID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRecruitment(@PathVariable("recID") String recID) {
        Recruitment recruitment = (Recruitment) recruitmentRepository.findOneByRecID(recID);
        recruitmentRepository.delete(recruitment);
        return ResponseEntity.status(HttpStatus.CREATED).body("Recruitment : " + recruitment.getRecID() + " is Successfully deleted");
    }
}
