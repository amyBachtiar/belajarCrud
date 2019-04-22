
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Assessment;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
 
/**
 *
 * @author Addi jo
 */
@Repository
@Transactional
public interface AssessmentRepository extends GenericRepository<Assessment>{
    Assessment findOneByEmpAssessId (String empAssessId);
}