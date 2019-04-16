
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Payrollitems;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nadya
 */
@Repository
@Transactional
public interface PayrollitemsRepository extends GenericRepository<Payrollitems>{
    
    Payrollitems findOneByPayrollitemsID(String payrollitemsID);
    
}
