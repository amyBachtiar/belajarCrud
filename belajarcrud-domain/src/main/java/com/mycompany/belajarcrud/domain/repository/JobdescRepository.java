/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Jobdesc;
import com.mycompany.belajarcrud.domain.repository.GenericRepository;

/**
 *
 * @author Eksad
 */
public interface JobdescRepository extends GenericRepository<Jobdesc>{
    
    Jobdesc findOneByJobdescId(String JobdescId);
}