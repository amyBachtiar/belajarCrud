package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Bizpar;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amy
 */
@Repository
@Transactional
public interface BizparRepository extends GenericRepository<Bizpar> {

    Bizpar findOneByKey(String key);
    
}
