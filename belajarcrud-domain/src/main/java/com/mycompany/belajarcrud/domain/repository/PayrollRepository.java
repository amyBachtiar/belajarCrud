
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Payroll;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nadya
 */
@Repository
@Transactional
public interface PayrollRepository extends GenericRepository<Payroll>{
    
    Payroll findOneByPayrollID(String payrollID);    

  
}
