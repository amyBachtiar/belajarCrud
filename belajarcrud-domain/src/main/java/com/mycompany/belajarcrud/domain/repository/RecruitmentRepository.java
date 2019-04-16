/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Recruitment;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SAMSUNG
 */

@Repository
@Transactional
public interface RecruitmentRepository extends GenericRepository<Recruitment> {

    Recruitment findOneByRecID(String recID);
    
}
