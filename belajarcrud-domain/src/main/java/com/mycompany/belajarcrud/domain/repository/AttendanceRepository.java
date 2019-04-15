
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Attendance;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reza Agika Putra
 */
@Repository
@Transactional
public interface AttendanceRepository extends GenericRepository<Attendance>{
    
    Attendance findOneByEmpId(String empId);
}
