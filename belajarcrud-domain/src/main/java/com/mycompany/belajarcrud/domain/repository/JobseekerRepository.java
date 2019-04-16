package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Jobseeker;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user-pc
 */
@Repository
@Transactional
public interface JobseekerRepository extends GenericRepository<Jobseeker>{
  
    Jobseeker findOneByJobID(String jobID); 
}
