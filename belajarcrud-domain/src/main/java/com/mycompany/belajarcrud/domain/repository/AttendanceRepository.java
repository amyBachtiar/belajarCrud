/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Attendance;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author noldy
 */
@Repository
@Transactional
public interface AttendanceRepository extends GenericRepository<Attendance>{
    
    Attendance findOneByCode(String code);
    
}
