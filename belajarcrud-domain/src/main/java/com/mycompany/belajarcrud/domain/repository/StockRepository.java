package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Stock;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amy
 */
@Repository
@Transactional
public interface StockRepository extends GenericRepository<Stock> {

    Stock findOneByCode(String code);
    
}
