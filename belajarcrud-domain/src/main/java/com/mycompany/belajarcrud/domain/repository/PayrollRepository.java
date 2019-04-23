/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.repository;

import com.mycompany.belajarcrud.domain.Payroll;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DanielCABN
 */
@Repository
@Transactional
public interface PayrollRepository extends GenericRepository<Payroll>{
    Payroll findOneByPayrollID(String PayrollID);
}
