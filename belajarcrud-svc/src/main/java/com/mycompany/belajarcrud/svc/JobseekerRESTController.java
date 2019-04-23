package com.mycompany.belajarcrud.svc;
import com.mycompany.belajarcrud.domain.Jobseeker;
import com.mycompany.belajarcrud.domain.assembler.JobseekerAssembler;
import com.mycompany.belajarcrud.domain.assembler.RecruitmentAssembler;
import com.mycompany.belajarcrud.domain.repository.JobseekerRepository;
import com.mycompany.belajarcrud.domain.repository.RecruitmentRepository;
import com.mycompany.belajarcrud.dto.JobseekerDTO;
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
 * @author ilma
 */

@RestController
@Slf4j
public class JobseekerRESTController {
    
    @Autowired
    JobseekerRepository jobseekerRepository;
    
    @Autowired
    RecruitmentRepository recruitmentRepository;

    @RequestMapping(value = "/get.jobseeker.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobseekerDTO> getJobseekerDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new JobseekerDTO().getInstance());
    }
    
    @RequestMapping(value = "/get.jobseeker.by.jobID/{jobID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobseekerDTO> getJobseekerByJobID(@PathVariable("jobID") String jobID) {
        Jobseeker data = jobseekerRepository.findOneByJobID(jobID);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new JobseekerAssembler().toDTO(data));
    }
    
    @RequestMapping(value = "/post.jobseeker",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobseekerDTO>postJobseeker(@RequestBody JobseekerDTO jobseekerDTO) {
        Jobseeker jobseeker = new JobseekerAssembler().toDomain(jobseekerDTO);
        jobseeker.setRec(new RecruitmentAssembler().toDomains(jobseekerDTO.getJobRec()));
        jobseekerRepository.save(jobseeker);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobseekerDTO);
    }
            
    @RequestMapping(value = "/update.jobseeker",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobseekerDTO> updateJobseeker(@RequestBody JobseekerDTO jobseekerDTO) {
         Jobseeker jobseeker = (Jobseeker) jobseekerRepository.findOneByJobID(jobseekerDTO.getJobID());
         jobseeker.setName(jobseekerDTO.getName());
         jobseeker.setEducation(jobseekerDTO.getEducation());
         jobseeker.setGpa(jobseekerDTO.getGpa());
         jobseeker.setUniversity(jobseekerDTO.getUniversity());
         jobseeker.setIntended_position(jobseekerDTO.getIntended_position());
        jobseekerRepository.save(jobseeker);
        return ResponseEntity.status(HttpStatus.CREATED).body(new JobseekerAssembler().toDTO(jobseeker));
    }
    
     @RequestMapping(value = "/delete.jobseeker/{jobID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteJobseeker(@PathVariable("jobID") String jobID) {
        Jobseeker jobseeker = (Jobseeker) jobseekerRepository.findOneByJobID(jobID);
        jobseekerRepository.delete(jobseeker);
        return ResponseEntity.status(HttpStatus.CREATED).body("Jobseeker : " + jobseeker.getJobID() + " is Successfully deleted");
    }
}