package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Company;
import com.mycompany.belajarcrud.domain.repository.GenericRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;



/**
 *
 * @author Mega
 */
@Repository
@Transactional
public interface CompanyRepository extends GenericRepository<Company>  {
    
        Company findOneByCompanyName(String companyName);

}
