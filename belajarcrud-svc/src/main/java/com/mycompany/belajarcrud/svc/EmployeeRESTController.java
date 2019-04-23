package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Attendance;
import com.mycompany.belajarcrud.domain.Company;
import com.mycompany.belajarcrud.domain.Employee;
import com.mycompany.belajarcrud.domain.assembler.AttendanceAssembler;
import com.mycompany.belajarcrud.domain.assembler.CNBAssembler;
import com.mycompany.belajarcrud.domain.assembler.CompanyAssembler;
import com.mycompany.belajarcrud.domain.assembler.EmployeeAssembler;
import com.mycompany.belajarcrud.domain.assembler.JobdescAssembler;
import com.mycompany.belajarcrud.domain.repository.AttendanceRepository;
import com.mycompany.belajarcrud.domain.repository.CNBRepository;
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
import com.mycompany.belajarcrud.dto.AttendanceDTO;
import com.mycompany.belajarcrud.dto.CompanyDTO;
import java.util.HashSet;
import java.util.Set;

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
    
    @Autowired
    AttendanceRepository attendanceRepository;
    
    @Autowired
    CNBRepository cnbRepository;
    
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
        Set<Attendance> att = new HashSet<Attendance>();
        for (AttendanceDTO attendanceIdsDTO : employeeDTO.getEmpAttendancesDTOs()) {
            att.add(attendanceRepository.findOneByAttendanceId(attendanceIdsDTO.getAttendanceId()));
        }
        employee.setEmpAttendances(att);
        employee.setCnb(new CNBAssembler().toDomain(employeeDTO.getCnbDTO()));
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
//        Employee employee = new EmployeeAssembler().toDomain(employeeDTO);
        Set<Attendance> attendances = new HashSet<Attendance>();
        for (AttendanceDTO adto : employeeDTO.getEmpAttendancesDTOs()){
            Attendance attendance = attendanceRepository.findOneByAttendanceId(adto.getAttendanceId());
            if(attendance != null){
                attendance.setDate(adto.getDate());
                attendances.add(attendance);
            } else {
                Attendance a = new AttendanceAssembler().toDomain(adto);
                attendances.add(a);
            }
        }
        employee.setEmpAttendances(attendances);
        employee.setCnb(new CNBAssembler().toDomain(employeeDTO.getCnbDTO()));
//      employee.setCompany(companyRepository.findOneByCompanyId(employeeDTO.getCompanyId()));
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
