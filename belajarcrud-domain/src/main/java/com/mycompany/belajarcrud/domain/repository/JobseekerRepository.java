package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Jobseeker;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ilma
 */

@Repository
@Transactional
public interface JobseekerRepository extends GenericRepository<Jobseeker>{
  
    Jobseeker findOneByJobID(String jobID); 
    
    
    
}