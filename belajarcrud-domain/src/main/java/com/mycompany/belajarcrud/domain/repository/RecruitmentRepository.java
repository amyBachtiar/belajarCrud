package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Recruitment;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ilma
 */

@Repository
@Transactional
public interface RecruitmentRepository extends GenericRepository<Recruitment> {

    Recruitment findOneByRecID(String recID);
    
}