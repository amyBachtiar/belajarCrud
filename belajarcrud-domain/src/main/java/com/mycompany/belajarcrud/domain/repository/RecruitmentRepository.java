package com.mycompany.belajarcrud.domain.repository;


import com.mycompany.belajarcrud.domain.Recruitment;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RecruitmentRepository extends GenericRepository<Recruitment> {

    Recruitment findOneByRecID(String recID);
    
}