package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Jobseeker;
import com.mycompany.belajarcrud.domain.Recruitment;
import com.mycompany.belajarcrud.domain.assembler.JobseekerAssembler;
import com.mycompany.belajarcrud.domain.assembler.RecruitmentAssembler;
import com.mycompany.belajarcrud.domain.repository.JobseekerRepository;
import com.mycompany.belajarcrud.domain.repository.RecruitmentRepository;
import com.mycompany.belajarcrud.dto.RecruitmentDTO;
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

    @RequestMapping(value = "/get.recruitment.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecruitmentDTO> getRecruitmentDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new RecruitmentDTO().getInstance());
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
    public ResponseEntity<?>postRecruitment(@RequestBody RecruitmentDTO recruitmentDTO) {
        Recruitment recruitment = new RecruitmentAssembler().toDomain(recruitmentDTO);
        recruitment.setJobseekers(new JobseekerAssembler().toDomains(recruitmentDTO.getRecJobs()));
        recruitmentRepository.save(recruitment);
        return ResponseEntity.status(HttpStatus.CREATED).body(recruitmentDTO);
    }

    @RequestMapping(value = "/update.recruitment",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecruitmentDTO> updateRecruitment(@RequestBody RecruitmentDTO recruitmentDTO) {
       Recruitment recruitment = (Recruitment) recruitmentRepository.findOneByRecID(recruitmentDTO.getRecID());
       //Jobseeker jobseeker = (Jobseeker) jobseekerRepository.findOneByJobID(recruitmentDTO.getJobID());
        recruitment.setRecType("Tipe Recruitment : ");
        recruitment.setStatus(true);
        recruitment.setJobseekers( new JobseekerAssembler().toDomains(recruitmentDTO.getRecJobs()));
//        jobseeker.setName("Name :");
//        jobseeker.setEducation("Eucation :");
//        jobseeker.setUniversity("university :");
//        jobseeker.setGpa(0);
//        jobseeker.setIntended_position("intended_position :");
//        recruitmentRepository.save(recruitment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RecruitmentAssembler().toDTO(recruitment));
    }

    @RequestMapping(value = "/delete.recruitment/{recID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRecruitment(@PathVariable("recID") String recID) {
        Recruitment recruitment = (Recruitment) recruitmentRepository.findOneByRecID(recID);
        recruitmentRepository.delete(recruitment);
        return ResponseEntity.status(HttpStatus.CREATED).body("Recruitment : " + recruitment.getRecID() + " is Successfully deleted");
    }
}
