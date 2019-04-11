package com.mycompany.belajarcrud.domain.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author merlinthie
 */
@NoRepositoryBean
public interface GenericRepository<T> extends PagingAndSortingRepository<T, Long> {
}
