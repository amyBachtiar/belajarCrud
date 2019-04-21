
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Attendance;
import com.mycompany.belajarcrud.domain.repository.GenericRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reza Agika Putra
 */
@Repository
@Transactional
public interface AttendanceRepository extends GenericRepository<Attendance>{
    
    Attendance findOneByAttendanceId(String attendanceId);
}