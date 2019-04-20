package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Company;
import com.mycompany.belajarcrud.domain.Employee;
import com.mycompany.belajarcrud.domain.assembler.EmployeeAssembler;
import com.mycompany.belajarcrud.domain.assembler.JobdescAssembler;
import com.mycompany.belajarcrud.domain.repository.CompanyRepository;
import com.mycompany.belajarcrud.dto.EmployeeDTO;
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
import com.mycompany.belajarcrud.domain.repository.EmployeeRepository;
import com.mycompany.belajarcrud.domain.repository.JobdescRepository;
import com.mycompany.belajarcrud.dto.CompanyDTO;

/**
 *
 * @author Mega
 */
@RestController
@Slf4j
public class EmployeeRESTController {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    CompanyRepository companyRepository;
    
     @Autowired
     JobdescRepository jobdescRepository;
    
    @RequestMapping(value="/get.employee.dummy",
            method=RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO>getEmployeeDummy(){
            return ResponseEntity.status(HttpStatus.FOUND).body(new EmployeeDTO().getInstance());
    }
    
    @RequestMapping(value="/get.employee.by.empID/{empID}",
           method=RequestMethod.GET,
           produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO>getEmployeeByEmpID(@PathVariable("empID") String empID){
        Employee data=employeeRepository.findOneByEmpId(empID);
        if(data==null){
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new EmployeeAssembler().toDTO(data));
        }
    
    @RequestMapping(value = "/post.employee",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new EmployeeAssembler().toDomain(employeeDTO);
//        employee.setCompany(companyRepository.findOneByCompanyId(employeeDTO.getCompanyId()));
        Company company = companyRepository.findOneByCompanyId(employeeDTO.getCompanyId());
        employee.setJobs(new JobdescAssembler().toDomains(employeeDTO.getEmpJobs()));
        if(company == null){
            return new ResponseEntity<String>("Company not found", HttpStatus.NOT_FOUND);
        }
        employee.setCompany(company);
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);
    }
    
    @RequestMapping(value="/update.employee",
            method=RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = (Employee) employeeRepository.findOneByEmpId(employeeDTO.getEmpId());
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setPosition(employeeDTO.getPosition());
        employee.setEmpStatus(employeeDTO.isEmpStatus());
        employee.setJobs(new JobdescAssembler().toDomains(employeeDTO.getEmpJobs()));
//        employee.setCompany(companyRepository.findOneByCompanyId(employeeDTO.getCompanyId()));
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EmployeeAssembler().toDTO(employee));
    }
    
    @RequestMapping(value = "/delete.employee/{empID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployee(@PathVariable("empID") String empID) {
        Employee employee = (Employee) employeeRepository.findOneByEmpId(empID);
        employeeRepository.delete(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee : " + employee.getEmpId()+ " is Successfully deleted");
    }
}
