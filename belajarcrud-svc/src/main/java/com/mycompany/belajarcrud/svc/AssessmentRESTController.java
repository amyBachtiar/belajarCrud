package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Assessment;
import com.mycompany.belajarcrud.domain.Employee;
import com.mycompany.belajarcrud.domain.assembler.AssessmentAssembler;
import com.mycompany.belajarcrud.domain.assembler.EmployeeAssembler;
import com.mycompany.belajarcrud.domain.assembler.JobdescAssembler;
import com.mycompany.belajarcrud.domain.repository.AssessmentRepository;
import com.mycompany.belajarcrud.domain.repository.EmployeeRepository;
import com.mycompany.belajarcrud.dto.AssessmentDTO;
import com.mycompany.belajarcrud.dto.EmployeeDTO;
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
 * @author Addi jio
 */
@RestController
@Slf4j
public class AssessmentRESTController {
    
    @Autowired
    AssessmentRepository assessmentRepository;
    
    @Autowired
    EmployeeRepository employeerepository;
    
    @RequestMapping(value="/get.assessment.dummy",
            method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssessmentDTO>getAssessmentDummy(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new AssessmentDTO().getInstance());
    }
    
    @RequestMapping(value = "/get.assessment.by.empAssessID/{empAssessID}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssessmentDTO> getAssessmentByEmpAssessID(@PathVariable("empAssessID") String empAssessId) {
        Assessment data = assessmentRepository.findOneByEmpAssessId(empAssessId);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new AssessmentAssembler().toDTO(data));
    }
    
    @RequestMapping(value = "/post.assessment",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssessmentDTO> postAssessment(@RequestBody AssessmentDTO assessmentDTO) {
//        Assessment assessment = new AssessmentAssembler().toDomain(assessmentDTO);
//        assessment.setEmployee(new EmployeeAssembler().toDomains(assessmentDTO.getEmployee()));
        assessmentRepository.save(new AssessmentAssembler().toDomain(assessmentDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(assessmentDTO);
    }
    
    @RequestMapping(value = "/update.assessment",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssessmentDTO> updateAssessment(@RequestBody AssessmentDTO assessmentDTO) {
        Assessment assessment = (Assessment) assessmentRepository.findOneByEmpAssessId(assessmentDTO.getEmpAssessId());
        assessment.setEmpAssessId(assessmentDTO.getEmpAssessId());
        assessment.setEmpAssessment(assessmentDTO.getEmpAssessment());
        
           Set<Employee> employees = new HashSet<Employee>();
        for (EmployeeDTO adto : assessmentDTO.getEmployeeDTOs()){
            Employee employee= employeerepository.findOneByEmpId(adto.getEmpId());
            if(employee != null){
                employee.setEmpId(adto.getEmpId());
                employee.setBirthDate(adto.getBirthDate());
                employee.setEmpName(adto.getEmpName());
                employee.setEmpStatus(adto.isEmpStatus());
                employee.setPosition(adto.getPosition());
                employees.add(employee);
            }else {
                Employee a = new EmployeeAssembler().toDomain(adto);
                employees.add(a);
            }
        }
//        assessment.setEmployee(new EmployeeAssembler().toDomains(assessmentDTO.getEmployee()));
        assessmentRepository.save(assessment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AssessmentAssembler().toDTO(assessment));
    }
    
   @RequestMapping(value = "/delete.assessment/{empAssessID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAssessment(@PathVariable("empAssessID") String empAssessID) {
        Assessment assessment = (Assessment) assessmentRepository.findOneByEmpAssessId(empAssessID);
        assessmentRepository.delete(assessment);
        return ResponseEntity.status(HttpStatus.CREATED).body("Assessment : " + assessment.getEmpAssessId()+ " is Successfully deleted");
    } 
}