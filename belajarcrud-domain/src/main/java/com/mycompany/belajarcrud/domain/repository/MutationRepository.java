package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Mutation;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MutationRepository extends GenericRepository<Mutation>{
    Mutation findOneByMutationNumber(String mutationNumber);
}
