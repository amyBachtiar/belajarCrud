package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Employee;
import com.mycompany.belajarcrud.domain.repository.GenericRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mega
 */
@Repository
@Transactional
public interface EmployeeRepository extends GenericRepository<Employee> {
    
    Employee findOneByEmpId(String empId);
    Employee findOneByEmpName(String empName);
}
