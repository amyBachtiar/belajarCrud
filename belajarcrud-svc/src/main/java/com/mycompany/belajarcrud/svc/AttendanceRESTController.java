package com.mycompany.belajarcrud.svc;

import com.mycompany.belajarcrud.domain.Attendance;
import com.mycompany.belajarcrud.domain.assembler.AttendanceAssembler;
import com.mycompany.belajarcrud.domain.repository.AttendanceRepository;
import com.mycompany.belajarcrud.domain.repository.EmployeeRepository;
import com.mycompany.belajarcrud.dto.AttendanceDTO;
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
 * @author Reza Agika Putra
 */
@RestController
@Slf4j
public class AttendanceRESTController {
    
    @Autowired
    AttendanceRepository attendanceRepository;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @RequestMapping(value = "/get.attendance.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttendanceDTO> getAttendanceDummy(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new AttendanceDTO().getInstance());
    }
    
    @RequestMapping(value = "/get.attendance.by.code/{code}", 
            method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttendanceDTO> getAttendanceByCode(@PathVariable("code") String code){
        Attendance data = attendanceRepository.findOneByCode(code);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new AttendanceAssembler().toDTO(data));
    }
    
    @RequestMapping(value = "/post.attendance",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttendanceDTO> postAttendance (@RequestBody AttendanceDTO attendanceDTO){
        Attendance attendance = new AttendanceAssembler().toDomain(attendanceDTO);
        attendance.setEmployee(employeeRepository.findOneByEmpId(attendanceDTO.getEmployeeId()));
        attendanceRepository.save(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(attendanceDTO);
    }
    
    @RequestMapping(value = "/update.attendance",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttendanceDTO> updateAttendance(@RequestBody AttendanceDTO attendanceDTO){
        Attendance attendance = (Attendance) attendanceRepository.findOneByCode(attendanceDTO.getCode());
        attendance.setDate(attendanceDTO.getDate());
        attendance.setTimeIn(attendanceDTO.getTimeIn());
        attendance.setTimeOut(attendanceDTO.getTimeOut());
        attendance.setEmployee(employeeRepository.findOneByEmpId(attendanceDTO.getEmployeeId()));
        attendanceRepository.save(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AttendanceAssembler().toDTO(attendance));
    }
    
    @RequestMapping(value = "/delete.attendance/{code}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAttendance(@PathVariable("code") String code){
        Attendance attendance = (Attendance) attendanceRepository.findOneByCode(code);
        attendanceRepository.delete(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body("Attendance : " + code + " is Succesfully deleted");
    }
}