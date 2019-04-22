package com.mycompany.belajarcrud.domain.repository;


import com.mycompany.belajarcrud.domain.Jobseeker;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface JobseekerRepository extends GenericRepository<Jobseeker>{
  
    Jobseeker findOneByJobID(String jobID); 
}