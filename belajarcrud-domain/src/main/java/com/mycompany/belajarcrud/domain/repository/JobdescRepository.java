
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Jobdesc;

/**
 *
 * @author Reza Agika Putra
 */
public interface JobdescRepository extends GenericRepository<Jobdesc>{
    
    Jobdesc findOneByJobdescId(String JobdescId);
}
