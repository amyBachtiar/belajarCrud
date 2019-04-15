package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Employee;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mega
 */
@Repository
@Transactional
public interface EmployeeRepository extends GenericRepository<Employee> {
    
    Employee findOneByEmpID(String empID);
}
