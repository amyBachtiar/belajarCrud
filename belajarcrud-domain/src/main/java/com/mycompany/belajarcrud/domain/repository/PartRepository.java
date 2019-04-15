package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Part;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amy
 */
@Repository
@Transactional
public interface PartRepository extends GenericRepository<Part> {

    Part findOneByCode(String code);

}
